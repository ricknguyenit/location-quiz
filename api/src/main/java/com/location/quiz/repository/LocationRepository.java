package com.location.quiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.location.quiz.entity.Location;

public interface LocationRepository extends MongoRepository<Location, String> {
    Optional<Location> findById(String id);
    
    List<Location> findByLocationNameIgnoreCaseContaining(String address);
}