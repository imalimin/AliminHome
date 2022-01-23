package com.alimin.home.model.repo

import com.alimin.home.model.entity.Skill
import com.alimin.home.model.entity.User


interface SkillRepo : BaseRepo<Skill> {
    fun findByUser(user: User): Array<Skill>
}