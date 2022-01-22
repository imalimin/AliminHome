package com.alimin.home.model.repo

import com.alimin.home.model.entity.Password
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface PasswordRepo : JpaRepository<Password, Int>, JpaSpecificationExecutor<User> {
}