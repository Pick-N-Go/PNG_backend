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
public class WishlistItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @Column(nullable = false)
    private Long spotId;

    @Column(length = 50)
    private String weatherCondition;

    @Column(length = 50)
    private String timeCondition;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Builder
    public WishlistItem(Wishlist wishlist, Long spotId, String weatherCondition, String timeCondition) {
        this.wishlist = wishlist;
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
