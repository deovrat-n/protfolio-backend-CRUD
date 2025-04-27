package com.example.demo.controller;
import com.example.demo.dto.PortfolioDTO;
import com.example.demo.model.Portfolio;
import com.example.demo.model.Stock;
import com.example.demo.model.User;
import com.example.demo.service.PortfolioService;
import com.example.demo.service.UserService;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    @Autowired
    private StockService stockService;

    @GetMapping
    public PortfolioDTO getUserPortfolio(Authentication authentication) {
        Optional<User> user = userService.findByUsername(authentication.getName());
        return user.map(u -> {
            Portfolio portfolio = u.getPortfolio();
            return new PortfolioDTO(
                portfolio.getId(),
                portfolio.getStocks().stream().map(Stock::getSymbol).toList()
            );
        }).orElseThrow();
    }

    @PostMapping("/add")
    public Portfolio addStockToPortfolio(@RequestParam Long stockId, Authentication authentication) {
        Optional<User> user = userService.findByUsername(authentication.getName());
        Optional<Stock> stock = stockService.getAllStocks().stream()
                .filter(s -> s.getId().equals(stockId))
                .findFirst();

        if (user.isPresent() && stock.isPresent()) {
            return portfolioService.addStockToPortfolio(user.get(), stock.get());
        } else {
            throw new RuntimeException("Invalid user or stock ID");
        }
    }
}
