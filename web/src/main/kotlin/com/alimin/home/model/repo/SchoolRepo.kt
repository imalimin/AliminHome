package com.alimin.home.model.repo

import com.alimin.home.model.entity.School
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface SchoolRepo : JpaRepository<School, Int>, JpaSpecificationExecutor<User> {
}