package com.example.demo.dto;

import java.util.List;

public class PortfolioDTO {
    private Long id;
    private List<String> stockNames;  // Change from List<Stock> to List<String>

    public PortfolioDTO(Long id, List<String> stockNames) {
        this.id = id;
        this.stockNames = stockNames;
    }

    public Long getId() {
        return id;
    }

    public List<String> getStockNames() {
        return stockNames;
    }
}
