package com.exception.wanted_june_task.domain.member.buyer.entity;

import com.exception.wanted_june_task.domain.member.parents.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Buyer extends Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder
    public Buyer(Long id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Buyer(Long id) {
        this.id = id;
    }
}
