package com.dayone.dividend_project.scraper;

import com.dayone.dividend_project.model.Company;
import com.dayone.dividend_project.model.ScrapedResult;

public interface Scraper {
    Company scrapCompanyByTicker(String ticker);
    ScrapedResult scrap(Company company);
}
