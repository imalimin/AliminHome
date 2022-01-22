package com.alimin.home.model.repo

import com.alimin.home.model.entity.Honor
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface HonorRepo : JpaRepository<Honor, Int>, JpaSpecificationExecutor<User> {
}