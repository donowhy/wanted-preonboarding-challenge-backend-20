package com.exception.wanted_june_task.domain.member.buyer.repository;

import com.exception.wanted_june_task.domain.member.buyer.entity.Buyer;
import com.exception.wanted_june_task.domain.product.entity.Product;

import java.util.List;

public interface BuyerCustomRepository {
    List<Product> findPurchasedProductsByBuyerId(Long buyerId);
    List<Product> findReservedProductsByBuyerId(Long buyerId);
}