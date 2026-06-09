package com.project.picngo.wishlist.dto;

public record WishlistUpdateRequest(
        String weatherCondition,
        String timeCondition,
        Boolean isActive
) {}
