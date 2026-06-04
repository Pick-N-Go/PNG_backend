package com.project.picngo.notification.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long userId;

    @Column(nullable = false)
    private Boolean isAllPushEnabled = true;

    private LocalTime dndStartTime;

    private LocalTime dndEndTime;

    @Builder
    public NotificationSetting(Long userId) {
        this.userId = userId;
        this.isAllPushEnabled = true;
    }

    public void updateSettings(Boolean isAllPushEnabled, LocalTime dndStartTime, LocalTime dndEndTime) {
        this.isAllPushEnabled = isAllPushEnabled;
        this.dndStartTime = dndStartTime;
        this.dndEndTime = dndEndTime;
    }
}



