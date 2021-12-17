package com.example.restservice.Exceptions;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long id) {
        super("Could not find location: " + id);
    }
}
