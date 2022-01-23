package com.alimin.home.model.services

import com.alimin.home.model.repo.PasswordRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PasswordService {
    @Autowired
    lateinit var repo: PasswordRepo
}