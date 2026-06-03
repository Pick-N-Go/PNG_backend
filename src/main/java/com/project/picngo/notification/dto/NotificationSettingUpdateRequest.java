package com.project.picngo.notification.dto;

import java.time.LocalTime;

public record NotificationSettingUpdateRequest(
        Boolean isAllPushEnabled,
        LocalTime dndStartTime,
        LocalTime dndEndTime
) {}
