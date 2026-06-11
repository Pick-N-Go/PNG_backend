package com.project.picngo.wishlist.controller;

import com.project.picngo.wishlist.dto.*;
import com.project.picngo.wishlist.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController implements WishlistControllerApiSpec {

    private final WishlistService wishlistService;
    // For now, hardcode user ID until Spring Security is fully integrated
    private final Long TEMP_USER_ID = 1L;

    @GetMapping
    public ResponseEntity<List<WishlistResponse>> getWishlist() {
        return ResponseEntity.ok(wishlistService.getWishlist(TEMP_USER_ID));
    }

    @PostMapping
    public ResponseEntity<WishlistResponse> createWishlist(@Valid @RequestBody WishlistCreateRequest request) {
        return ResponseEntity.ok(wishlistService.createWishlist(TEMP_USER_ID, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistResponse> getWishlistDetail(@PathVariable Long id) {
        return ResponseEntity.ok(wishlistService.getWishlistDetail(id, TEMP_USER_ID));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishlistResponse> updateWishlist(@PathVariable Long id, @Valid @RequestBody WishlistUpdateRequest request) {
        return ResponseEntity.ok(wishlistService.updateWishlist(id, TEMP_USER_ID, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        wishlistService.deleteWishlist(id, TEMP_USER_ID);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<WishlistItemResponse> addItemToWishlist(
            @PathVariable Long id,
            @Valid @RequestBody WishlistItemRequest request) {
        return ResponseEntity.ok(wishlistService.addItemToWishlist(id, TEMP_USER_ID, request));
    }

    @DeleteMapping("/{id}/items/{itemId}")
    public ResponseEntity<Void> removeItemFromWishlist(
            @PathVariable Long id,
            @PathVariable Long itemId) {
        wishlistService.removeItemFromWishlist(id, itemId, TEMP_USER_ID);
        return ResponseEntity.noContent().build();
    }
}
