package com.telefonica.rickandmorty.service;

import com.rickandmortyapi.Episode;
import com.rickandmortyapi.Character;
import com.telefonica.rickandmorty.dto.CharacterAppearancesDTO;
import com.telefonica.rickandmorty.exception.CharacterNotFoundApiError;
import com.telefonica.rickandmorty.exception.CharacterWithEmptyEpisodesApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CharacterService {

    public CharacterAppearancesDTO getCharacterAppearancesByName(String name) {
        CharacterAppearancesDTO characterAppearancesDTO = new CharacterAppearancesDTO();
        log.info("Getting character appearance by name: {}", name);
        Character character = new Character().withName(name).filter().stream().findFirst()
            .orElseThrow(CharacterNotFoundApiError::new);
        characterAppearancesDTO.setName(character.getName());
        log.info("Character found: {}", character.getName());
        // Only returns episodes Ids
        List<Episode> characterEpisodes = character.getEpisodes();
        // Also get each episode info (name)
        characterEpisodes.forEach((episode) -> episode.refresh());
        characterAppearancesDTO.setEpisodes(characterEpisodes.stream()
            .map(Episode::getName).collect(Collectors.toList()));
        // Get the first Character Episode by show date (air_date)
        Episode firstEpisode = characterEpisodes.stream().min(Comparator.comparing(Episode::getShowDate))
            .orElseThrow(CharacterWithEmptyEpisodesApiError::new);
        characterAppearancesDTO.setFirstAppearance(firstEpisode.getShowDate()
            .format(DateTimeFormatter.ofPattern("d MMMM YYYY", Locale.forLanguageTag("es-ES"))));
        return characterAppearancesDTO;
    }
}
