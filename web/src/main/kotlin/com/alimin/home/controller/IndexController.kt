package com.alimin.home.controller

import com.alimin.home.State
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

@RequestMapping("/")
interface IndexController {
    @RequestMapping(value = ["/", "index"])
    fun index(model: Model, uid: Long): ModelAndView

    @ResponseBody
    @RequestMapping(value = ["/template"], method = [RequestMethod.GET])
    fun getTemplate(request: HttpServletRequest, tid: String): State<*>

    @ResponseBody
    @RequestMapping(value = ["/get_my_resume"], method = [RequestMethod.GET])
    fun getMyResume(request: HttpServletRequest, uid: Long): State<*>
}