package com.mission42.repo;

import com.mission42.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegRepo extends JpaRepository<User, String> {
    List<User> findFirstByUserName(String userName);
}
