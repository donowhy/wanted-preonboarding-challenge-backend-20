package com.exception.wanted_june_task.domain.buying.service;

import com.exception.wanted_june_task.domain.buying.entity.Buying;
import com.exception.wanted_june_task.domain.buying.repository.BuyingRepository;
import com.exception.wanted_june_task.domain.buying.service.dto.BuyingProduct;
import com.exception.wanted_june_task.domain.member.buyer.entity.Buyer;
import com.exception.wanted_june_task.domain.member.buyer.repository.BuyerRepository;
import com.exception.wanted_june_task.domain.product.entity.Product;
import com.exception.wanted_june_task.domain.product.entity.Status;
import com.exception.wanted_june_task.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyingService {

    private final BuyingRepository buyingRepository;
    private final ProductRepository productRepository;
    private final BuyerRepository buyerRepository;

    public void buyingProduct (BuyingProduct buyingProduct, Long buyerId) throws Throwable {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow();
        Product product = productRepository.findById(buyingProduct.getProductId()).orElseThrow(Throwable::new);
        boolean isSelling = checkedProductOfStatus(product);
        if(!isSelling) {
            throw new Exception();
        }
        product.reservation();
        Buying buying = Buying.builder()
                .buyer(buyer)
                .product(product)
                .build();

        buyingRepository.save(buying);
    }

    private boolean checkedProductOfStatus (Product product) {
        return product.getStatus().equals(Status.SELLING);
    }

}
