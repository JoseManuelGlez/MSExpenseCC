package org.example.msexpensecc.service.interfaces;

import org.example.msexpensecc.controller.requests.CreateExpenseRequest;
import org.example.msexpensecc.controller.responses.BaseResponse;

public interface IExpenseService {
    BaseResponse create(CreateExpenseRequest request);

    BaseResponse getExpensesByUserId(String userId);
}
