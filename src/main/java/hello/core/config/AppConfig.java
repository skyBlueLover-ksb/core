package hello.core.config;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OrderService;
import hello.core.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private MemberRepository memberRepository;
    private MemberService memberService;
    private OrderService orderService;
    private DiscountPolicy discountPolicy;

    @Bean
    public MemberRepository memberRepository() {
        if (memberRepository == null)
            memberRepository = new MemoryMemberRepository();

        return memberRepository;
    }

    @Bean
    public MemberService memberService() {
        if (memberService == null)
            memberService = new MemberServiceImpl(memberRepository());

        return memberService;
    }

    @Bean
    public OrderService orderService() {
        if (orderService == null)
            orderService = new OrderServiceImpl(memberRepository(), discountPolicy());

        return orderService;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        if (discountPolicy == null)
            //discountPolicy = new FixDiscountPolicy();
            discountPolicy = new RateDiscountPolicy();

        return discountPolicy;
    }

}
