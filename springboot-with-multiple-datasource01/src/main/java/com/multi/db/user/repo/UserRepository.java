package com.multi.db.user.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.db.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

}
