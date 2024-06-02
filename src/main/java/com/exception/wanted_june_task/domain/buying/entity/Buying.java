package com.exception.wanted_june_task.domain.buying.entity;

import com.exception.wanted_june_task.domain.member.buyer.entity.Buyer;
import com.exception.wanted_june_task.domain.member.parents.Member;
import com.exception.wanted_june_task.domain.product.entity.Product;
import com.exception.wanted_june_task.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class Buying extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
