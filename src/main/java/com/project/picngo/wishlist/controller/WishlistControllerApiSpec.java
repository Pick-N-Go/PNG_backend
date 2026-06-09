package com.project.picngo.wishlist.controller;

import com.project.picngo.wishlist.dto.WishlistCreateRequest;
import com.project.picngo.wishlist.dto.WishlistResponse;
import com.project.picngo.wishlist.dto.WishlistUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "위시리스트 (Wishlist)", description = "사용자 찜(위시리스트) 관리 API")
public interface WishlistControllerApiSpec {

    @Operation(summary = "내 위시리스트 목록 조회", description = "사용자가 생성한 모든 위시리스트 폴더를 조회합니다.")
    ResponseEntity<List<WishlistResponse>> getWishlist();

    @Operation(summary = "위시리스트 생성", description = "새로운 위시리스트(폴더)를 생성합니다.")
    ResponseEntity<WishlistResponse> createWishlist(@RequestBody WishlistCreateRequest request);

    @Operation(summary = "위시리스트 상세 조회", description = "특정 위시리스트 폴더 안의 항목(코스/명소)을 조회합니다.")
    ResponseEntity<WishlistResponse> getWishlistDetail(@Parameter(description = "위시리스트 ID") @PathVariable Long id);

    @Operation(summary = "위시리스트 수정", description = "위시리스트 폴더의 이름 등을 수정합니다.")
    ResponseEntity<WishlistResponse> updateWishlist(
            @Parameter(description = "위시리스트 ID") @PathVariable Long id,
            @RequestBody WishlistUpdateRequest request
    );

    @Operation(summary = "위시리스트 삭제", description = "위시리스트 폴더를 삭제합니다.")
    ResponseEntity<Void> deleteWishlist(@Parameter(description = "위시리스트 ID") @PathVariable Long id);
}
