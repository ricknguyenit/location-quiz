package com.location.quiz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.location.quiz.entity.Location;
import com.location.quiz.service.LocationService;

@RestController
@RequestMapping("/api/location")
@CrossOrigin("*")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping
    public Location create(@Valid @RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") String id, @Valid @RequestBody Location location) {
        locationService.updateLocation(id, location);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        locationService.deleteLocation(id);
    }

    @GetMapping
    public List<Location> list() {
        return locationService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Location findById(@PathVariable("id") String id) {
        return locationService.getLocationById(id);
    }

    @GetMapping(value = "/search")
    public List<Location> search(@RequestParam String address) {
        return locationService.searchLocation(address);
    }
}
