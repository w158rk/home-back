package com.api.services.mysql;

import org.springframework.stereotype.Service;

import com.api.models.Project;
import com.api.repositories.ProjectRepository;
import com.api.services.ProjectService;

@Service
public class ProjectServiceMysql implements ProjectService {

	private ProjectRepository projectRepository;	
	
	public ProjectServiceMysql(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public Project findProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Iterable<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Long id, Project project) {
		if (id != project.getId()) {
			return null;	
		}
		
		return projectRepository.save(project);
	}

	@Override
	public void deleteProjectById(Long id) {
		
		projectRepository.deleteById(id);
		
	}

}
