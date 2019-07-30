package com.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
