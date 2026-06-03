package com.project.picngo.course.dto;

import java.util.List;

public record CourseSpotOrderUpdateRequest(
        List<Long> spotIds
) {}
