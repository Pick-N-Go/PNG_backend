package com.project.picngo.wishlist.domain;

import com.project.picngo.common.domain.BaseTimeEntity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wishlist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long spotId;

    @Column(length = 50)
    private String weatherCondition; // e.g. CLEAR, CLOUDY

    @Column(length = 50)
    private String timeCondition; // e.g. SUNRISE, SUNSET

    @Column(nullable = false)
    private Boolean isActive = true;

    @Builder
    public Wishlist(Long userId, Long spotId, String weatherCondition, String timeCondition) {
        this.userId = userId;
        this.spotId = spotId;
        this.weatherCondition = weatherCondition;
        this.timeCondition = timeCondition;
        this.isActive = true;
    }

    public void updateConditions(String weatherCondition, String timeCondition, Boolean isActive) {
        this.weatherCondition = weatherCondition;
        this.timeCondition = timeCondition;
        this.isActive = isActive;
    }
}



