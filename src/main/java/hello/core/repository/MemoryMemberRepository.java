package hello.core.repository;


import hello.core.member.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> memberMap = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        memberMap.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberMap.get(memberId);
    }
}
