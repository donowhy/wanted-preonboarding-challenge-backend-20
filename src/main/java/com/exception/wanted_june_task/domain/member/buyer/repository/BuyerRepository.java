package com.exception.wanted_june_task.domain.member.buyer.repository;


import com.exception.wanted_june_task.domain.member.buyer.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long>, BuyerCustomRepository{
}
