package com.dayone.dividend_project.persist.entity;

import com.dayone.dividend_project.model.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "COMPANY")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ticker;

    private String name;

    public CompanyEntity(Company company){

        this.ticker = company.getTicker();
        this.name = company.getName();
    }

}