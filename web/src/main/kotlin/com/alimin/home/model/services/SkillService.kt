package com.alimin.home.model.services

import com.alimin.home.model.repo.SkillRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SkillService {
    @Autowired
    lateinit var repo: SkillRepo
}