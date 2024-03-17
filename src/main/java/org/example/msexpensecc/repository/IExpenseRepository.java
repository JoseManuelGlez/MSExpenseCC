package org.example.msexpensecc.repository;

import org.example.msexpensecc.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends JpaRepository<Expense, String> {
}
