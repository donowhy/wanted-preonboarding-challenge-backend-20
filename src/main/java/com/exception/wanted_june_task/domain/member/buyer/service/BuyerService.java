package com.exception.wanted_june_task.domain.member.buyer.service;

import com.exception.wanted_june_task.domain.buying.repository.BuyingRepository;
import com.exception.wanted_june_task.domain.member.buyer.entity.Buyer;
import com.exception.wanted_june_task.domain.member.buyer.repository.BuyerRepository;
import com.exception.wanted_june_task.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public List<Product> getOrderedProduct (Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow();
        return buyerRepository.findPurchasedProductsByBuyerId(buyerId);
    }

    public List<Product> getReservedProducts(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow();
        return buyerRepository.findReservedProductsByBuyerId(buyerId);
    }

}
