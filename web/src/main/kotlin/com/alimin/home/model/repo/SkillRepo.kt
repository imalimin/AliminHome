package com.alimin.home.model.repo

import com.alimin.home.model.entity.Skill
import com.alimin.home.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface SkillRepo : JpaRepository<Skill, Int>, JpaSpecificationExecutor<User> {
}