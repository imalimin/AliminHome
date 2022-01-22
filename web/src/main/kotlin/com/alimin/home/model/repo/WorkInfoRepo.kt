package com.alimin.home.model.repo

import com.alimin.home.model.entity.User
import com.alimin.home.model.entity.WorkInfo


interface WorkInfoRepo : BaseRepo<WorkInfo> {
    fun findByUser(user: User): Array<WorkInfo>
}