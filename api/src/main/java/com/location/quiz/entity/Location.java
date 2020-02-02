package com.location.quiz.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Location {
    @Id
    private String id;
    private Double lat;
    private Double lng;
    private String locationName;
}