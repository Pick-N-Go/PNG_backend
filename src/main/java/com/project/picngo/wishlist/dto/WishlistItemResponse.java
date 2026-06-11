package com.project.picngo.wishlist.dto;

import com.project.picngo.wishlist.domain.WishlistItem;

public record WishlistItemResponse(
        Long id,
        Long spotId,
        String weatherCondition,
        String timeCondition,
        Boolean isActive
) {
    public static WishlistItemResponse from(WishlistItem item) {
        return new WishlistItemResponse(
                item.getId(),
                item.getSpotId(),
                item.getWeatherCondition(),
                item.getTimeCondition(),
                item.getIsActive()
        );
    }
}
