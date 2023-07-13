package com.jbground.jpa;

import com.jbground.jpa.execute.MemberExecute;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MemberTest {

    @Resource(type = MemberExecute.class)
    MemberExecute memberExecute;

    @Test
    void memberTest1(){

        memberExecute.addMembers();


    }
}
