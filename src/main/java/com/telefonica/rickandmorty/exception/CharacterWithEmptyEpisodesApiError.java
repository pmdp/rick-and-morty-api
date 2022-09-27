package com.telefonica.rickandmorty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No episodes for this character")
public class CharacterWithEmptyEpisodesApiError extends RuntimeException {
}
