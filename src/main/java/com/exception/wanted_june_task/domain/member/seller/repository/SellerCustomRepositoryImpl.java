package com.exception.wanted_june_task.domain.member.seller.repository;

import com.exception.wanted_june_task.domain.product.entity.Product;
import com.exception.wanted_june_task.domain.product.entity.Status;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.exception.wanted_june_task.domain.buying.entity.QBuying.buying;
import static com.exception.wanted_june_task.domain.member.buyer.entity.QBuyer.buyer;
import static com.exception.wanted_june_task.domain.member.seller.entity.QSeller.seller;
import static com.exception.wanted_june_task.domain.product.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class SellerCustomRepositoryImpl implements SellerCustomRepository {
    private final JPAQueryFactory query;

    @Override
    public List<Product> findPurchasedProductsBySellerId(Long sellerId) {
        return query.select(product)
                .from(product)
                .where(seller.id.eq(sellerId))
                .fetch();
    }

    @Override
    public List<Product> findReservedProductsBySellerId(Long sellerId) {
        return query.select(product)
                .from(product)
                .join(product.purchaseList, buying)
                .where(seller.id.eq(sellerId).and(product.status.eq(Status.RESERVATION)))
                .fetch();
    }
}
