package com.matrix.Spring.repository;

import com.matrix.Spring.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {

}
