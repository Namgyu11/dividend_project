package com.dayone.dividend_project.persist.repository;

import com.dayone.dividend_project.persist.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    boolean existsByTicker(String ticker);

    //Optional 사용 이유-> 해당 이름(ticker)으로 검색된 회사 엔티티가 없을 수도 있기 때문
    Optional<CompanyEntity> findByName(String name);

}
