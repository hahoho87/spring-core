package com.devbaek.springcore.discount;

import com.devbaek.springcore.annotation.MainDiscountPolicy;
import com.devbaek.springcore.member.Grade;
import com.devbaek.springcore.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
    }
}
