package com.exception.wanted_june_task.domain.buying.repository;

import com.exception.wanted_june_task.domain.buying.entity.Buying;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyingRepository extends JpaRepository<Buying, Long> {
}
