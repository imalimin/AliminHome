package com.alimin.home.model.repo

import com.alimin.home.model.entity.PageInfo
import com.alimin.home.model.entity.User


interface PageInfoRepo : BaseRepo<PageInfo> {
    fun findByUser(user: User): Array<PageInfo>
}