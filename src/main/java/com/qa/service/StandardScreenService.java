package com.qa.service;

import com.qa.repo.StandardScreensRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardScreenService {

    private final StandardScreensRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public StandardScreenService(StandardScreensRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }


}
