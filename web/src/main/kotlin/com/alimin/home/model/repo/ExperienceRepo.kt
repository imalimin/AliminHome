package com.alimin.home.model.repo

import com.alimin.home.model.entity.Experience
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ExperienceRepo : JpaRepository<Experience, Int>, JpaSpecificationExecutor<User> {
}