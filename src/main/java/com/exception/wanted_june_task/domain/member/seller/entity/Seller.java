package com.exception.wanted_june_task.domain.seller.entity;

import com.exception.wanted_june_task.domain.buying.entity.Buying;
import com.exception.wanted_june_task.domain.member.entity.Member;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Seller extends Member {

    private String storeName;

    @Builder
    public Seller(Long id, String name, String email, String password, List<Buying> buyingList, String storeName) {
        super(id, name, email, password, buyingList);
        this.storeName = storeName;
    }
}
