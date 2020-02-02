package com.location.quiz.service;

import java.util.List;

import com.location.quiz.entity.Location;

public interface LocationService {
    Location createLocation(Location location);

    Location updateLocation(String id, Location location);

    void deleteLocation(String id);

    List<Location> getAll();

    Location getLocationById(String id);

    List<Location> searchLocation(String id);
}
