package com.exception.wanted_june_task.domain.member.seller.entity;

import com.exception.wanted_june_task.domain.member.parents.Member;
import com.exception.wanted_june_task.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Seller extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    @OneToMany(mappedBy = "id")
    private List<Product> productList;

    @Builder
    public Seller(Long id, String name, String email, String password, String storeName) {
        super(id, name, email, password);
        this.storeName = storeName;
    }

    public Seller(Long id, String storeName) {
        this.id = id;
        this.storeName = storeName;
    }
}
