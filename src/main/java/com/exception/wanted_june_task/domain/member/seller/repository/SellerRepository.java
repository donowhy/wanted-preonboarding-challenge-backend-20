package com.exception.wanted_june_task.domain.member.seller.repository;

import com.exception.wanted_june_task.domain.member.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>, SellerCustomRepository {
}
