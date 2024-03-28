package org.example.msexpensecc.service;

import org.example.msexpensecc.controller.requests.CreateExpenseRequest;
import org.example.msexpensecc.controller.responses.BaseResponse;
import org.example.msexpensecc.controller.responses.GetExpenseResponse;
import org.example.msexpensecc.entity.Expense;
import org.example.msexpensecc.entity.User;
import org.example.msexpensecc.repository.IExpenseRepository;
import org.example.msexpensecc.repository.IUserRepository;
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

    @Autowired
    private IUserRepository userRepository;

    @Override
    public BaseResponse create(CreateExpenseRequest request) {
        Expense expense = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(expense)))
                .message("Expense added correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse getExpensesByUserId(String userId) {
        List<Expense> expenses = repository.findByUserId(userId);

        return BaseResponse.builder()
                .data(expenses)
                .message("Expenses found correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    private GetExpenseResponse from(Expense expense){
        GetExpenseResponse response = new GetExpenseResponse();

        response.setId(expense.getId());
        response.setMount(expense.getMount());
        response.setDate(expense.getDate());
        response.setCategory(expense.getCategory());
        response.setDescription(expense.getDescription());

        User user = userRepository.findUserById(expense.getUser().getId());

        expense.setUser(user);

        return response;
    }

    private Expense from(CreateExpenseRequest request){
        Expense expense = new Expense();

        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());
        expense.setMount(request.getMount());
        expense.setDescription(request.getDescription());

        User user = userRepository.findUserById(request.getUserId());

        expense.setUser(user);

        return expense;
    }
}
