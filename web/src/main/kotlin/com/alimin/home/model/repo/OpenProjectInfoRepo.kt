package com.alimin.home.model.repo

import com.alimin.home.model.entity.OpenProjectInfo
import com.alimin.home.model.entity.User

interface OpenProjectInfoRepo : BaseRepo<OpenProjectInfo> {
    fun findByUser(user: User): Array<OpenProjectInfo>
}