package com.project.picngo.wishlist.controller;

import com.project.picngo.wishlist.dto.WishlistCreateRequest;
import com.project.picngo.wishlist.dto.WishlistResponse;
import com.project.picngo.wishlist.dto.WishlistUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @GetMapping
    public ResponseEntity<List<WishlistResponse>> getWishlist() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    public ResponseEntity<WishlistResponse> createWishlist(@RequestBody WishlistCreateRequest request) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistResponse> getWishlistDetail(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishlistResponse> updateWishlist(@PathVariable Long id, @RequestBody WishlistUpdateRequest request) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
