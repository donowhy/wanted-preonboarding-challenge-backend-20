package com.exception.wanted_june_task.domain.product.entity;

import com.exception.wanted_june_task.domain.buying.entity.Buying;
import com.exception.wanted_june_task.domain.member.seller.entity.Seller;
import com.exception.wanted_june_task.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 7)
    private String name;

    @NotBlank
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "id")
    private List<Buying> purchaseList;

    public void reservation() {
        this.status = Status.RESERVATION;
    }
}
