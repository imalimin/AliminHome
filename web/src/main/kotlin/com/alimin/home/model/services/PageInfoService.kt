package com.alimin.home.model.services

import com.alimin.home.model.repo.PageInfoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PageInfoService {
    @Autowired
    lateinit var repo: PageInfoRepo
}