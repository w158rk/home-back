package com.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Project;
import com.api.services.ProjectService;

@RestController
@RequestMapping(ProjectController.BASE_URL)
public class ProjectController {

	private final ProjectService projectService;
	public static final String BASE_URL = "/api/v1/projects";

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	
	@GetMapping
	public Iterable<Project> getAllProjects() {
		
		return projectService.findAllProjects();
		
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable Long id) {
		
		return projectService.findProjectById(id);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProjectById(@PathVariable Long id) {
		
		projectService.deleteProjectById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Project saveProject(@RequestBody Project project) {
		
		return projectService.saveProject(project);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
		
		return projectService.updateProject(id, project);
	}
	
}
