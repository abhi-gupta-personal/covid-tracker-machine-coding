package com.abhishek.covidproj.repository;

import com.abhishek.covidproj.models.AdminUser;
import com.abhishek.covidproj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
