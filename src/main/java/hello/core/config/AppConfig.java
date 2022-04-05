package hello.core.config;

import hello.core.discount.FixDiscountPolicy;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OrderService;
import hello.core.service.OrderServiceImpl;

public class AppConfig {
    private MemberRepository memberRepository;

    public MemberRepository getMemberRepository() {
        if (memberRepository == null)
            memberRepository = new MemoryMemberRepository();

        return memberRepository;

    }

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), new FixDiscountPolicy());
    }

}
