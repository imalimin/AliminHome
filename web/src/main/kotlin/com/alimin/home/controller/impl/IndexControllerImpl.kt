package com.alimin.home.controller.impl

import com.alimin.home.controller.IndexController
import com.alimin.home.model.entity.vo.ExperienceResumeVo
import com.alimin.home.model.entity.vo.UserResume
import com.alimin.home.model.services.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView

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
    private lateinit var openProjectInfoService: OpenProjectInfoService
    @Autowired
    private lateinit var pageInfoService: PageInfoService

    override fun index(model: Model, uid: Long): ModelAndView {
        val userOptional = userService.repo.findById(uid)
        if (userOptional.isPresent) {
            val user = userOptional.get()
            val userWrapper = UserResume(user,
                    schoolService.repo.findByUser(user),
                    workInfoService.repo.findByUser(user),
                    skillService.repo.findByUser(user),
                    experienceService.repo.findByUser(user),
                    honorService.repo.findByUser(user),
                    openProjectInfoService.repo.findByUser(user),
                    pageInfoService.repo.findByUser(user))
            val experiences = ArrayList<ExperienceResumeVo>()
            userWrapper.experience.forEach {
                experiences.add(ExperienceResumeVo(it.begin, it.end, it.project, it.position, it.intro, it.detail.split("\\n").toTypedArray(), it.work))
            }

            model.addAttribute("user", user)
            model.addAttribute("schools", userWrapper.school)
            model.addAttribute("works", userWrapper.works)
            model.addAttribute("skills", userWrapper.skills)
            model.addAttribute("experiences", experiences)
            model.addAttribute("honors", userWrapper.honors)
            model.addAttribute("projects", userWrapper.projects)
            model.addAttribute("pages", userWrapper.pages)
            return ModelAndView("index", "model", model)
        }
        return ModelAndView("error")
    }
}