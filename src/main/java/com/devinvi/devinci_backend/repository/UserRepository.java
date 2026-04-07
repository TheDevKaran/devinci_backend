package com.devinvi.devinci_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devinvi.devinci_backend.dto.UserAdminView;
import com.devinvi.devinci_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
    @Query("""
        SELECT u.email AS email, u.createdAt AS createdAt
        FROM User u
    """)
    List<UserAdminView> fetchAllUsersForAdmin();
}
