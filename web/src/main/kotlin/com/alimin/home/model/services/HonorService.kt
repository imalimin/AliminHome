package com.alimin.home.model.services

import com.alimin.home.model.repo.HonorRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HonorService {
    @Autowired
    lateinit var repo: HonorRepo
}