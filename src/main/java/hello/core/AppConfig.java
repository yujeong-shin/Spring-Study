package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // MemberService 역할
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // MemberRepository 역할
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // OrderService 역할
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }

    // DiscountPolicy 역할
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}