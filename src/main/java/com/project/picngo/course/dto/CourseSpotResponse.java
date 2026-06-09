package com.project.picngo.course.dto;

public record CourseSpotResponse(
        Long id,
        Long spotId,
        Integer dayNumber,
        Integer sequenceOrder,
        String memo,
        Integer travelTimeMinutes
) {}
