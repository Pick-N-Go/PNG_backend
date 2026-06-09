package com.project.picngo.wishlist.dto;

public record WishlistCreateRequest(
        Long spotId,
        String weatherCondition,
        String timeCondition
) {}
