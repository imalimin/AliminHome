package com.alimin.home.model.repo

import com.alimin.home.model.entity.PageInfo
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface PageInfoRepo : JpaRepository<PageInfo, Int>, JpaSpecificationExecutor<User> {
}