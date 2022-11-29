package com.pharmabms.repository;

import com.pharmabms.entity.PharmaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmaUserRepository extends JpaRepository<PharmaUser, String> {
}
