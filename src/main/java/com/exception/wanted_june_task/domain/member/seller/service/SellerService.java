package com.exception.wanted_june_task.domain.member.seller.service;

import com.exception.wanted_june_task.domain.member.seller.entity.Seller;
import com.exception.wanted_june_task.domain.member.seller.repository.SellerRepository;
import com.exception.wanted_june_task.domain.member.seller.service.dto.Register;
import com.exception.wanted_june_task.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public void registerSeller(Register register) {
        Seller seller = Seller.builder()
                .name(register.getName())
                .email(register.getEmail())
                .password(register.getPassword())
                .storeName(register.getStoreName())
                .build();

        sellerRepository.save(seller);
    }

    public List<Product> getOrderedProduct (Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
        return sellerRepository.findPurchasedProductsBySellerId(sellerId);
    }

    public List<Product> getReservedProducts(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
        return sellerRepository.findReservedProductsBySellerId(sellerId);
    }
}
