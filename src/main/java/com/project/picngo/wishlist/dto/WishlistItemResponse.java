package com.project.picngo.wishlist.dto;

import com.project.picngo.wishlist.domain.WishlistItem;
import com.project.picngo.wishlist.domain.enums.TimeCondition;
import com.project.picngo.wishlist.domain.enums.WeatherCondition;

public record WishlistItemResponse(
        Long id,
        Long spotId,
        WeatherCondition weatherCondition,
        TimeCondition timeCondition,
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
