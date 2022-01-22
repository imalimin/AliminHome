package com.alimin.home.model.repo

import com.alimin.home.model.entity.Honor
import com.alimin.home.model.entity.User

interface HonorRepo : BaseRepo<Honor> {
    fun findByUser(user: User): Array<Honor>
}