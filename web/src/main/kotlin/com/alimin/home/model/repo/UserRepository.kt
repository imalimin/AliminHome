package com.alimin.home.model.repo

import com.alimin.home.model.entity.User

interface UserRepository : BaseRepo<User> {
    fun existsByName(name: String): Boolean
    fun findByName(name: String): User?
}