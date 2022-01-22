package com.alimin.home.model.repo

import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserRepository : JpaRepository<User, Int>, JpaSpecificationExecutor<User> {
    fun existsByName(name: String): Boolean
    fun findByName(name: String): User?
}