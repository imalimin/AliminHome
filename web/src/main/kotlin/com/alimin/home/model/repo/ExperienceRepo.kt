package com.alimin.home.model.repo

import com.alimin.home.model.entity.Experience
import com.alimin.home.model.entity.User

interface ExperienceRepo : BaseRepo<Experience> {
    fun findByUser(user: User): Array<Experience>
}