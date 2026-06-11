package com.project.picngo.wishlist.dto;

import com.project.picngo.wishlist.domain.enums.TimeCondition;
import com.project.picngo.wishlist.domain.enums.WeatherCondition;

public record WishlistItemRequest(
        Long spotId,
        WeatherCondition weatherCondition,
        TimeCondition timeCondition
) {}
