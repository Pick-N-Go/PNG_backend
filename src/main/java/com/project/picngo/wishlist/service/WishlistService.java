package com.project.picngo.wishlist.service;

import com.project.picngo.external.WeatherClient;
import com.project.picngo.wishlist.dto.WishlistCreateRequest;
import com.project.picngo.wishlist.dto.WishlistResponse;
import com.project.picngo.wishlist.dto.WishlistUpdateRequest;
import com.project.picngo.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final WeatherClient weatherClient;

    @Transactional
    public WishlistResponse createWishlist(Long userId, WishlistCreateRequest request) {
        // TODO: Implement create wishlist logic
        return null;
    }

    public List<WishlistResponse> getWishlist(Long userId) {
        // TODO: Implement get wishlist logic
        return List.of();
    }

    @Transactional
    public WishlistResponse updateWishlist(Long id, WishlistUpdateRequest request) {
        // TODO: Implement update wishlist logic
        return null;
    }

    // Scheduled task to check conditions
    @Transactional
    public void checkConditionsAndNotify() {
        // TODO: Get all active wishlists, use weatherClient to check conditions, and notify
    }
}
