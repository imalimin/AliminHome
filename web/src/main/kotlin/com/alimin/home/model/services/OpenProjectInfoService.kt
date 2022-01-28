package com.alimin.home.model.services

import com.alimin.home.model.repo.OpenProjectInfoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OpenProjectInfoService {
    @Autowired
    lateinit var repo: OpenProjectInfoRepo
}