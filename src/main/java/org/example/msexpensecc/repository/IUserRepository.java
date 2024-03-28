package org.example.msexpensecc.repository;

import org.example.msexpensecc.entity.User;
import org.example.msexpensecc.entity.projections.IUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT users.id AS userId, " +
            "users.email AS userEmail, users.password AS userPassword FROM users " +
            "WHERE users.email = :email AND users.password = :password ;", nativeQuery = true)
    IUserProjection findUserByEmailAndPassword(String email, String password);

    User findUserById(String userId);
}
