package com.exception.wanted_june_task.domain.member.buyer.repository;

import com.exception.wanted_june_task.domain.product.entity.Product;
import com.exception.wanted_june_task.domain.product.entity.Status;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.exception.wanted_june_task.domain.buying.entity.QBuying.buying;
import static com.exception.wanted_june_task.domain.member.buyer.entity.QBuyer.buyer;
import static com.exception.wanted_june_task.domain.product.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class BuyerCustomRepositoryImpl implements BuyerCustomRepository{
    private final JPAQueryFactory query;

    /**
     * select from where join on groupBy having
     * @param buyerId
     * @return
     */
    @Override
    public List<Product> findPurchasedProductsByBuyerId(Long buyerId) {
        return query.select(product)
                .from(product)
                .where(buyer.id.eq(buyerId))
                .fetch();
    }

    @Override
    public List<Product> findReservedProductsByBuyerId(Long buyerId) {
        return query.select(product)
                .from(product)
                .join(product.purchaseList, buying)
                .where(buyer.id.eq(buyerId).and(product.status.eq(Status.RESERVATION)))
                .fetch();
    }
}
