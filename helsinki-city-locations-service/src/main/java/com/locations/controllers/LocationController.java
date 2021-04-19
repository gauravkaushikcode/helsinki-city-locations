package com.locations.controllers;

import com.locations.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
///http://localhost:3000 changes done for heroku deployment...
@CrossOrigin(origins = "https://hel-location-client.herokuapp.com")
public class LocationController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping("/locations")
    public MappingJacksonValue getAllLocations() throws IOException {
        return locationsService.getData();
    }
}
