package com.telefonica.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.threeten.bp.LocalDate;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterAppearancesDTO {

    private String name;
    private List<String> episodes;
    private String firstAppearance;
}
