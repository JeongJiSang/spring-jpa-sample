package com.jbground.jpa.execute;

import com.jbground.jpa.entity.Member;
import com.jbground.jpa.repository.hibernate.MemberRepository;
import com.jbground.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberExecute {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    public void addMembers(){
        Member member1 = new Member();
        member1.setId(1111L);
        member1.setName("지원");

        Member member2 = new Member();
        member2.setId(1112L);
        member2.setName("현수");

        memberService.join(member1);
        memberService.join(member2);
    }
}
