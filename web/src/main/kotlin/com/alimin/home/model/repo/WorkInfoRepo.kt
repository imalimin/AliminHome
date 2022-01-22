package com.alimin.home.model.repo

import com.alimin.home.model.entity.User
import com.alimin.home.model.entity.WorkInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface WorkInfoRepo : JpaRepository<WorkInfo, Int>, JpaSpecificationExecutor<User> {
}