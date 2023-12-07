package com.dayone.dividend_project.web;

import com.dayone.dividend_project.model.Company;
import com.dayone.dividend_project.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    /**
     * 배당금을 검색할 때 자동완성이 되도록 하는 API
     * @param keyword
     * @return
     */
    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam String keyword){
        return null;
    }

    //회사리스트를 조회하는 API
    @GetMapping
    public ResponseEntity<?>searchCompany(){
        return null;
    }

    //배당금 데이터를 저장 ,삭제
    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody Company request){
        String ticker = request.getTicker().trim();
        if(ObjectUtils.isEmpty(ticker)){
            throw new RuntimeException("ticker is empty");
        }
        Company company = this.companyService.save(ticker);


        return ResponseEntity.ok(company);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteCompany(){
        return null;
    }
}
