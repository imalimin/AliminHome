package com.alimin.home.model.services

import com.alimin.home.model.entity.User
import com.alimin.home.model.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var repo: UserRepository

    fun put(o: User) {
        repo.save(o)
    }

    fun existsByName(name: String): Boolean {
        return repo.existsByName(name)
    }

    fun findByName(name: String): User? {
        return repo.findByName(name)
    }
}