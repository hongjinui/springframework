package com.test.springframework.domain.repogitory;

import com.test.springframework.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
