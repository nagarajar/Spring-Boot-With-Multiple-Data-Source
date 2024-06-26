package com.multi.db.account.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.db.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Serializable> {

}
