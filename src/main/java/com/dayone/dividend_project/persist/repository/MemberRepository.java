package com.dayone.dividend_project.persist.repository;


import com.dayone.dividend_project.persist.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // Id 기준으로 회원 정보 찾기
    Optional<MemberEntity> findByUsername(String username);

    // 회원 가입할 때 이미 존재하는 Id 인지 확인
    boolean existsByUsername(String username);
}
