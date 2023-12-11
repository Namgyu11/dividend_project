package com.dayone.dividend_project.service;

import com.dayone.dividend_project.exception.impl.NoCompanyException;
import com.dayone.dividend_project.model.Company;
import com.dayone.dividend_project.model.Dividend;
import com.dayone.dividend_project.model.ScrapedResult;
import com.dayone.dividend_project.model.constants.CacheKey;
import com.dayone.dividend_project.persist.entity.CompanyEntity;
import com.dayone.dividend_project.persist.entity.DividendEntity;
import com.dayone.dividend_project.persist.repository.CompanyRepository;
import com.dayone.dividend_project.persist.repository.DividendRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class FinanceService {

    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;


    @Cacheable(key = "#companyName", value = CacheKey.KEY_FINANCE)
    public ScrapedResult getDividendByCompanyName(String companyName) {
        log.info("search company ->" + companyName);
        //1. 회사명을 기준으로 정보를 조회
        CompanyEntity company = this.companyRepository.findByName(companyName)
                .orElseThrow(NoCompanyException::new);

        //2. 조회된 회사 ID로 배당금 정보 조회
        List<DividendEntity> dividendEntities =
                this.dividendRepository.findAllByCompanyId(company.getId());

        //3. 결과 조합 후 반환

        /* for 문 사용
        List<Dividend> dividends = new ArrayList<>();
        for (var entity : dividendEntities) {
            dividends.add(Dividend.builder()
                    .date(entity.getDate())
                    .dividend(entity.getDividend())
                    .build());
        }
         */

        List<Dividend> dividends = dividendEntities.stream()
                .map(e -> new Dividend(e.getDate(), e.getDividend()))
                .collect(Collectors.toList());


        return new ScrapedResult(new Company(company.getTicker(), company.getName()),
                dividends);
    }
}
