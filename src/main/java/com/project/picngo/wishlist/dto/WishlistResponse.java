package com.project.picngo.wishlist.dto;

public record WishlistResponse(
        Long id,
        Long spotId,
        String weatherCondition,
        String timeCondition,
        Boolean isActive
) {}
