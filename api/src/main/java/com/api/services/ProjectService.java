package com.api.services;

import com.api.models.Project;

public interface ProjectService {

	Project findProjectById(Long id);
	
	Iterable<Project> findAllProjects();
	
	Project saveProject(Project project);

	Project updateProject(Long id, Project project);
	
	void deleteProjectById(Long id);

}
