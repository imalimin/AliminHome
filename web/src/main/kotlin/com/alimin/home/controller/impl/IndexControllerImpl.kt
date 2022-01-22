package com.alimin.home.controller.impl

import com.alimin.home.State
import com.alimin.home.controller.IndexController
import com.alimin.home.model.entity.vo.UserResume
import com.alimin.home.model.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.Base64Utils
import org.springframework.util.ResourceUtils
import org.springframework.web.servlet.ModelAndView
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import javax.servlet.http.HttpServletRequest

@Controller
class IndexControllerImpl : IndexController {
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

    override fun index(model: Model): ModelAndView {
        return ModelAndView("index")
    }

    override fun getTemplate(request: HttpServletRequest, tid: String): State<*> {
        val file = ResourceUtils.getFile("classpath:static/assets/default_red.template")
        if (file.exists()) {
            val reader = BufferedReader(InputStreamReader(FileInputStream(file), "UTF-8"))
            val str = reader.readText()
            return State.success(Base64Utils.encodeToString(str.toByteArray()))
        }
        return State.fail("Template not found.")
    }

    override fun getMyResume(request: HttpServletRequest, uid: Long): State<*> {
        val userOptional = userService.repo.findById(uid)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            val userWrapper = UserResume(user,
                    schoolService.repo.findByUser(user),
                    workInfoService.repo.findByUser(user),
                    skillService.repo.findByUser(user),
                    experienceService.repo.findByUser(user),
                    honorService.repo.findByUser(user),
                    pageInfoService.repo.findByUser(user))
            userWrapper.school.forEach { it.user = null }
            userWrapper.works.forEach { it.user = null }
            userWrapper.skills.forEach { it.user = null }
            userWrapper.experience.forEach { it.user = null }
            userWrapper.honors.forEach { it.user = null }
            return State.success(userWrapper)
        }
        return State.fail("Resume not found.")
    }

}