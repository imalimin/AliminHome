package com.alimin.home.model.services

import com.alimin.home.model.repo.WorkInfoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorkInfoService {
    @Autowired
    lateinit var repo: WorkInfoRepo
}