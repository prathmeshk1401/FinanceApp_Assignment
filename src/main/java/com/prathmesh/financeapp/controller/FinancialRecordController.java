package com.prathmesh.financeapp.controller;

import com.prathmesh.financeapp.model.FinancialRecord;
import com.prathmesh.financeapp.service.FinancialRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    private final FinancialRecordService service;

    public FinancialRecordController(FinancialRecordService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public FinancialRecord create(
            @RequestBody FinancialRecord record,
            @RequestHeader("role") String role) {

        return service.create(record, role);
    }

    // GET ALL
    @GetMapping
    public List<FinancialRecord> getAll(@RequestHeader("role") String role) {
        return service.getAll(role);
    }

    // FILTER
    @GetMapping("/filter")
    public List<FinancialRecord> filter(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category) {

        return service.filter(type, category);
    }

    // DASHBOARD APIs

    @GetMapping("/summary/income")
    public double income() {
        return service.totalIncome();
    }

    @GetMapping("/summary/expense")
    public double expense() {
        return service.totalExpense();
    }

    @GetMapping("/summary/net")
    public double net() {
        return service.netBalance();
    }
}