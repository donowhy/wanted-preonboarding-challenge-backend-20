package com.exception.wanted_june_task.domain.seller.service;

import com.exception.wanted_june_task.domain.seller.entity.Seller;
import com.exception.wanted_june_task.domain.seller.repository.SellerRepository;
import com.exception.wanted_june_task.domain.seller.service.dto.Register;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
