package com.project.picngo.wishlist.dto;

import com.project.picngo.wishlist.domain.enums.TimeCondition;
import com.project.picngo.wishlist.domain.enums.WeatherCondition;

import jakarta.validation.constraints.NotNull;

public record WishlistItemRequest(
        @NotNull(message = "스팟 ID는 필수입니다.")
        Long spotId,
        @NotNull(message = "날씨 조건은 필수입니다. (설정하지 않으려면 NONE)")
        WeatherCondition weatherCondition,
        @NotNull(message = "시간 조건은 필수입니다. (설정하지 않으려면 NONE)")
        TimeCondition timeCondition
) {}
