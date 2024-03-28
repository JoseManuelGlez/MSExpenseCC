package org.example.msexpensecc.controller;

import org.example.msexpensecc.controller.requests.CreateExpenseRequest;
import org.example.msexpensecc.controller.responses.BaseResponse;
import org.example.msexpensecc.service.interfaces.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseController {
    @Autowired
    private IExpenseService service;

    @GetMapping("{userId}")
    public ResponseEntity<BaseResponse> getExpensesByUserId(@PathVariable String userId) {
        BaseResponse baseResponse = service.getExpensesByUserId(userId);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateExpenseRequest request) {
        BaseResponse baseResponse = service.create(request);

        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }
}
