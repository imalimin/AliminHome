package com.alimin.home.model.services

import com.alimin.home.model.repo.SchoolRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SchoolService {
    @Autowired
    lateinit var repo: SchoolRepo
}