package com.project.picngo.external.dto;

public record DirectionsResponse(
        Integer travelTimeMinutes,
        Integer travelDistanceMeters
) {}
