package com.project.picngo.wishlist.domain;

import com.project.picngo.common.domain.BaseTimeEntity;
import com.project.picngo.wishlist.domain.enums.TimeCondition;
import com.project.picngo.wishlist.domain.enums.WeatherCondition;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WishlistItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @Column(nullable = false)
    private Long spotId;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private WeatherCondition weatherCondition;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TimeCondition timeCondition;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Builder
    public WishlistItem(Wishlist wishlist, Long spotId, WeatherCondition weatherCondition, TimeCondition timeCondition) {
        this.wishlist = wishlist;
        this.spotId = spotId;
        this.weatherCondition = weatherCondition;
        this.timeCondition = timeCondition;
        this.isActive = true;
    }

    public void updateConditions(WeatherCondition weatherCondition, TimeCondition timeCondition, Boolean isActive) {
        this.weatherCondition = weatherCondition;
        this.timeCondition = timeCondition;
        this.isActive = isActive;
    }
}
