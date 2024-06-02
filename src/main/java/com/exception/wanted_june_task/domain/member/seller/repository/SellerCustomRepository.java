package com.exception.wanted_june_task.domain.member.seller.repository;

import com.exception.wanted_june_task.domain.product.entity.Product;

import java.util.List;

public interface SellerCustomRepository {
    List<Product> findPurchasedProductsBySellerId(Long sellerId);
    List<Product> findReservedProductsBySellerId(Long sellerId);
}