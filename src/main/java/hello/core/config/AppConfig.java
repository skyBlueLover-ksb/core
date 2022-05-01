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

public class AppConfig {
    private MemberRepository memberRepository;
    private MemberService memberService;
    private OrderService orderService;
    private DiscountPolicy discountPolicy;

    public MemberRepository memberRepository() {
        if (memberRepository == null)
            memberRepository = new MemoryMemberRepository();

        return memberRepository;
    }

    public MemberService memberService() {
        if (memberService == null)
            memberService = new MemberServiceImpl(memberRepository());

        return memberService;
    }

    public OrderService orderService() {
        if (orderService == null)
            orderService = new OrderServiceImpl(memberRepository(), discountPolicy());

        return orderService;
    }

    private DiscountPolicy discountPolicy() {
        if (discountPolicy == null)
            //discountPolicy = new FixDiscountPolicy();
            discountPolicy = new RateDiscountPolicy();

        return discountPolicy;
    }

}
