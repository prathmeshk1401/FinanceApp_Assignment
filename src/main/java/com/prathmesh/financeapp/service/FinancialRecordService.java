package com.prathmesh.financeapp.service;

import com.prathmesh.financeapp.model.FinancialRecord;
import com.prathmesh.financeapp.repository.FinancialRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    private final FinancialRecordRepository repo;

    public FinancialRecordService(FinancialRecordRepository repo) {
        this.repo = repo;
    }

    public FinancialRecord create(FinancialRecord record, String role) {

        if (!"ADMIN".equalsIgnoreCase(role)) {
            throw new RuntimeException("Only ADMIN can create records");
        }

        return repo.save(record);
    }

    public List<FinancialRecord> getAll(String role) {
        return repo.findAll();
    }

    public List<FinancialRecord> filter(String type, String category) {

        if (type != null && category != null) {
            return repo.findByTypeAndCategory(type, category);
        } else if (type != null) {
            return repo.findByType(type);
        } else if (category != null) {
            return repo.findByCategory(category);
        }

        return repo.findAll();
    }

    // DASHBOARD LOGIC

    public double totalIncome() {
        return repo.findAll().stream()
                .filter(r -> "INCOME".equalsIgnoreCase(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double totalExpense() {
        return repo.findAll().stream()
                .filter(r -> "EXPENSE".equalsIgnoreCase(r.getType()))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double netBalance() {
        return totalIncome() - totalExpense();
    }
}