package com.matrix.Spring.repository;

import com.matrix.Spring.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
   AccountEntity findByName(String name);
}
