package com.alimin.home

import com.alimin.home.model.entity.vo.UserResume
import com.alimin.home.model.services.*
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.ResourceUtils
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

@SpringBootTest
class AliminHomeApplicationTests {
    @Autowired
    private lateinit var userService: UserService
    @Autowired
    private lateinit var schoolService: SchoolService
    @Autowired
    private lateinit var workInfoService: WorkInfoService
    @Autowired
    private lateinit var skillService: SkillService
    @Autowired
    private lateinit var experienceService: ExperienceService
    @Autowired
    private lateinit var honorService: HonorService

    fun contextLoads() {
    }

    @Test
    fun initUser() {
        val file = ResourceUtils.getFile("classpath:static/bin/alimin_private.json")
        if (file.exists()) {
            val reader = BufferedReader(InputStreamReader(FileInputStream(file), "UTF-8"))
            val str = reader.readText()
            val mapper = jacksonObjectMapper().apply { configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) }
            val userWrapper = mapper.readValue(str, UserResume::class.java)
            println(userWrapper)

            if (!userService.existsByName(userWrapper.user.name)) {
                val user = userWrapper.user
                userService.put(user)
                userWrapper.school.forEach {
                    it.user = user
                    schoolService.repo.save(it)
                }
                userWrapper.works.forEach {
                    it.user = user
                    workInfoService.repo.save(it)
                }
                userWrapper.skills.forEach {
                    it.user = user
                    skillService.repo.save(it)
                }
                userWrapper.experience.forEach {
                    it.user = user
                    experienceService.repo.save(it)
                }
                userWrapper.honors.forEach {
                    it.user = user
                    honorService.repo.save(it)
                }
            }
        }
    }

}
