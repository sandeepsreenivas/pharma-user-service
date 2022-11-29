package com.pharmabms.service.impl;

import com.pharmabms.entity.PharmaUserId;
import com.pharmabms.repository.PharmaUserIdRepository;
import com.pharmabms.service.PharmaUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PharmaUserIdServiceImpl implements PharmaUserIdService {

    @Autowired
    private PharmaUserIdRepository repository;

    @Override
    public Integer getCurrentUserId() {
        return repository.findById(1).get().getCurrentUserId();
    }

    @Override
    public void updateCurrentUserId(Integer currentUserId) {
        PharmaUserId pharmaUserId = repository.findById(1).get();
        pharmaUserId.setCurrentUserId(currentUserId);
        repository.save(pharmaUserId);
    }
}
