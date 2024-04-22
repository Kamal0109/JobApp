package com.kamal.JobApp.controller;

import ch.qos.logback.core.model.Model;
import com.kamal.JobApp.model.JobPost;
import com.kamal.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    // ************************************************************************

    @RequestMapping({"/","/home"})
    public String home() {
        return "home";
    }

    // ************************************************************************

    @RequestMapping("/addjob")
    public String addJob() {
        return "addjob";
    }

    // ************************************************************************

    // controller method for getting all job posts
    @GetMapping("/viewalljobs")
    public String viewJobs(ModelMap model) {
        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }
    // ************************************************************************

    @PostMapping("/handleForm")
    public ModelAndView handleAddJobForm(JobPost jobPost) {
        service.addJobPost(jobPost);
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("jobPost", jobPost);
        return modelAndView;
    }













}