package com.alimin.home.model.entity.vo

import com.alimin.home.model.entity.*

data class UserResume constructor(
        var user: User,
        var school: Array<School>,
        var works: Array<WorkInfo>,
        var skills: Array<Skill>,
        var experience: Array<Experience>,
        var honors: Array<Honor>
)