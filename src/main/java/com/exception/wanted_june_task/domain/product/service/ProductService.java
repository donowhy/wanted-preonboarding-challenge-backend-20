package com.exception.wanted_june_task.domain.product.service;

import com.exception.wanted_june_task.domain.member.buyer.service.dto.GoodsInfo;
import com.exception.wanted_june_task.domain.member.seller.entity.Seller;
import com.exception.wanted_june_task.domain.member.seller.repository.SellerRepository;
import com.exception.wanted_june_task.domain.product.entity.Product;
import com.exception.wanted_june_task.domain.product.entity.Status;
import com.exception.wanted_june_task.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    public void registerGoods (GoodsInfo goodsInfo, Long sellerId) throws Throwable {

        Seller seller = sellerRepository.findById(sellerId).orElseThrow(Throwable::new);

        Product product = Product.builder()
                .name(goodsInfo.getName())
                .price(goodsInfo.getPrice())
                .seller(seller)
                .status(Status.SELLING)
                .build();

        productRepository.save(product);
    }


}
