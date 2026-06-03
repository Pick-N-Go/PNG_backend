package com.project.picngo.notification.dto;

import java.time.LocalDateTime;

public record NotificationResponse(
        Long id,
        String type,
        String title,
        String content,
        Boolean isRead,
        String deepLink,
        LocalDateTime createdAt
) {}
