package com.project.picngo.wishlist.dto;

import com.project.picngo.wishlist.domain.Wishlist;

import java.util.List;
import java.util.stream.Collectors;

public record WishlistResponse(
        Long id,
        String name,
        List<WishlistItemResponse> items
) {
    public static WishlistResponse from(Wishlist wishlist) {
        return new WishlistResponse(
                wishlist.getId(),
                wishlist.getName(),
                wishlist.getItems().stream()
                        .map(WishlistItemResponse::from)
                        .collect(Collectors.toList())
        );
    }
}
