package com.project.picngo.wishlist.repository;

import com.project.picngo.wishlist.domain.Wishlist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    @EntityGraph(attributePaths = {"items"})
    List<Wishlist> findAllByUserId(Long userId);
}
