package com.example.demo.service;

import com.example.demo.model.Portfolio;
import com.example.demo.model.Stock;
import com.example.demo.model.User;
import com.example.demo.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    // Get user's portfolio
    public Optional<Portfolio> getUserPortfolio(User user) {
        return portfolioRepository.findByUser(user);
    }

    // Add stock to an existing portfolio instead of creating a new one each time
    public Portfolio addStockToPortfolio(User user, Stock stock) {
        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseGet(() -> {
                    Portfolio newPortfolio = new Portfolio();
                    newPortfolio.setUser(user);
                    return newPortfolio;
                });

        portfolio.getStocks().add(stock);  // Add stock to existing list
        return portfolioRepository.save(portfolio);
    }
}
