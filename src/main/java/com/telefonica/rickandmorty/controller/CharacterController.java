package com.telefonica.rickandmorty.controller;

import com.telefonica.rickandmorty.dto.CharacterAppearancesDTO;
import com.telefonica.rickandmorty.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/character")
@Slf4j
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping(value = "/search-character-appearance", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CharacterAppearancesDTO getEpisodesCharacterAppearance(@RequestParam String name) {
        log.info("Request incoming with parameter (name): {}", name);
        return characterService.getCharacterAppearancesByName(name);
    }

}
