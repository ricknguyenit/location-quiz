package com.location.quiz.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.quiz.entity.Location;
import com.location.quiz.repository.LocationRepository;
import com.location.quiz.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        location.setId(UUID.randomUUID().toString());
        return locationRepository.save(location);
    }

    public Location updateLocation(String id, Location location) {
        location.setId(id);
        return locationRepository.save(location);
    }

    public void deleteLocation(String id) {
        Location location = locationRepository.findById(id).orElse(null);
        locationRepository.delete(location);
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location getLocationById(String id) {
        return locationRepository.findById(id).orElse(null);
    }

    public List<Location> searchLocation(String address) {
        return locationRepository.findByLocationNameIgnoreCaseContaining(address);
    }
}