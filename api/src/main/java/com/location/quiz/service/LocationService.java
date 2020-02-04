package com.location.quiz.service;

import java.util.List;

import com.location.quiz.entity.Location;

public interface LocationService {
    /**
     * Create new location
     * 
     * @param location
     * @return
     */
    Location createLocation(Location location);

    /**
     * Update existing location
     * 
     * @param id
     * @param location
     * @return
     */
    Location updateLocation(String id, Location location);

    /**
     * Delete location
     * 
     * @param id
     */
    void deleteLocation(String id);

    /**
     * Get all location
     * 
     * @return
     */
    List<Location> getAll();

    /**
     * Get location by id
     * 
     * @param id
     * @return
     */
    Location getLocationById(String id);

    /**
     * Search location
     * 
     * @param id
     * @return
     */
    List<Location> searchLocation(String id);
}
