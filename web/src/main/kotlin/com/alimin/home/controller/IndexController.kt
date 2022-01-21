package com.alimin.home.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@RequestMapping("/")
interface IndexController {
    @RequestMapping(value = ["/", "index"])
    fun index(model: Model): ModelAndView
}