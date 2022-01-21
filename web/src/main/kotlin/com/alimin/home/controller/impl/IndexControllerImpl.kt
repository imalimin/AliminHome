package com.alimin.home.controller.impl

import com.alimin.home.controller.IndexController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexControllerImpl : IndexController {
    override fun index(model: Model): ModelAndView {
        return ModelAndView("index")
    }

}