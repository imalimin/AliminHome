package com.alimin.home.model.repo

import com.alimin.home.model.entity.School
import com.alimin.home.model.entity.User


interface SchoolRepo : BaseRepo<School> {
    fun findByUser(user: User): Array<School>
}