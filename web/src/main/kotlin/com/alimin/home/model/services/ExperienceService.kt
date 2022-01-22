package com.alimin.home.model.services

import com.alimin.home.model.repo.ExperienceRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExperienceService {
    @Autowired
    lateinit var repo: ExperienceRepo
}