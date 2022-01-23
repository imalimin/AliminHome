package com.alimin.home.model.entity.vo

data class ExperienceResumeVo(
        var begin: String,
        var end: String,
        var project: String,
        var position: String,
        var intro: String,
        var details: Array<String>,
        var work: String
) {
}