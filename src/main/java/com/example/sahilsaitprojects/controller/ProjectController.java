package com.example.sahilsaitprojects.controller;

import com.example.sahilsaitprojects.model.Project;
import com.example.sahilsaitprojects.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private final ProjectRepo projectRepo;

    public ProjectController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @GetMapping(value = "/projects")
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @GetMapping(value = "/projects/{id}")
    public Project getProject(@PathVariable Long id) {
        Project project = projectRepo.findById(id).get();
        return project;
    }

    @PostMapping(value = "/projects")
    public String addProject(@RequestBody Project project) {
        projectRepo.save(project);
        return "project added";
    }

    @PatchMapping(value = "/projects/{id}")
    public Project editProjectDetails(@PathVariable Long id, @RequestBody Project projectDetails) {
        Project project = projectRepo.findById(id).get();
        if(projectDetails.getName() != null)
            project.setName(projectDetails.getName());
        if(projectDetails.getDescription() != null)
            project.setDescription(projectDetails.getDescription());
        if(projectDetails.getUrl() != null)
            project.setUrl(projectDetails.getUrl());
        if(projectDetails.getGithub() != null)
            project.setGithub(projectDetails.getGithub());
        projectRepo.save(project);
        return project;
    }


    @DeleteMapping(value = "/projects/{id}")
    public String deleteProject(@PathVariable Long id) {
        Project project = projectRepo.findById(id).get();
        projectRepo.delete(project);
        return "project " + id + " deleted";
    }

}

