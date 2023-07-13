package com.jbground.jpa.repository.hibernate;

import com.jbground.jpa.dao.hibernate.AbstractHibernateDao;
import com.jbground.jpa.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends AbstractHibernateDao<Member> {

    public MemberRepository(){
        setClazz(Member.class);
    }
}
