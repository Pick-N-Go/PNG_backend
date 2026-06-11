package com.project.picngo.wishlist.domain;

import com.project.picngo.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wishlist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishlistItem> items = new ArrayList<>();

    @Builder
    public Wishlist(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void addItem(WishlistItem item) {
        this.items.add(item);
    }
}
