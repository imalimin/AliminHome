package com.alimin.home.model.repo

import com.alimin.home.model.entity.Password
import com.alimin.home.model.entity.User


interface PasswordRepo : BaseRepo<Password> {
    fun findByUser(user: User): Array<Password>
}