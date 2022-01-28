package com.alimin.home

import com.alimin.home.model.entity.OpenProjectInfo
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
    @Autowired
    private lateinit var pageInfoService: PageInfoService
    @Autowired
    private lateinit var openProjectInfoService: OpenProjectInfoService

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
                userWrapper.pages.forEach {
                    it.user = user
                    pageInfoService.repo.save(it)
                }
            }
        }
    }

    @Test
    fun initOpenProjects() {
        val userOptional = userService.repo.findById(1)
        if (userOptional.isPresent) {
            val project0 = OpenProjectInfo("HardwareVideoCodec", "Android音视频编解码SDK", "github", "使用OpenGL ES实现图像的高性能渲染，利用FFmpeg、MediaCodec以及X264实现视频的软硬件编解码，引入图层支持，实现多轨道的混合", "")
            project0.user = userOptional.get()
            openProjectInfoService.repo.save(project0)
            val project1 = OpenProjectInfo("FilmKilns", "跨平台高性能音视频编解码SDK", "github", "拥有图片编辑、音视频录制、视频多轨道编辑三大核心功能，HardwareVideoCodec的跨平台实现，使用C/C++实现，并引入合理的软件架构，方便跨平台移植", "")
            project1.user = userOptional.get()
            openProjectInfoService.repo.save(project1)
        }
    }
}
