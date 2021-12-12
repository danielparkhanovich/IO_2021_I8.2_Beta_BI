package com.example.restservice.Exceptions;

public class BuildingNotFoundException extends RuntimeException {

    public BuildingNotFoundException(Long id) {
        super("Could not find building: " + id);
    }
}
