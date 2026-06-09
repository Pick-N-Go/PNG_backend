package com.project.picngo.course.dto;

public record CourseSpotAddRequest(
        Long spotId,
        Integer dayNumber,
        Integer sequenceOrder,
        String memo
) {}
