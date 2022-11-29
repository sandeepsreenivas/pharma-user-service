package com.pharmabms.repository;

import com.pharmabms.entity.PharmaUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmaUserIdRepository extends JpaRepository<PharmaUserId, Integer> {
}
