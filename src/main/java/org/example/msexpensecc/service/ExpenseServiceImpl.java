package org.example.msexpensecc.service;

import org.example.msexpensecc.controller.responses.BaseResponse;
import org.example.msexpensecc.controller.responses.ListExpenseResponse;
import org.example.msexpensecc.entity.Expense;
import org.example.msexpensecc.repository.IExpenseRepository;
import org.example.msexpensecc.service.interfaces.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements IExpenseService {
    @Autowired
    private IExpenseRepository repository;

    @Override
    public BaseResponse list() {
        List<ListExpenseResponse> expenses = repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());

        return BaseResponse.builder()
                .data(expenses)
                .message("Expenses found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private ListExpenseResponse from(Expense expense){
        ListExpenseResponse response = new ListExpenseResponse();

        response.setId(expense.getId());
        response.setMount(expense.getMount());
        response.setDate(expense.getDate());
        response.setCategory(expense.getCategory());
        response.setDescription(expense.getDescription());

        return response;
    }
}
