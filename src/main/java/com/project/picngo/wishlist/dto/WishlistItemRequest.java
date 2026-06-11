package com.project.picngo.wishlist.dto;

public record WishlistItemRequest(
        Long spotId,
        String weatherCondition,
        String timeCondition
) {}
