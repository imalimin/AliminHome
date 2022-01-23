package com.alimin.home.model.repo

import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepo<T> : JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}

@NoRepositoryBean
interface UserRelationRepo<T> : BaseRepo<T> {
    fun findByUser(user: User): Array<T>
}