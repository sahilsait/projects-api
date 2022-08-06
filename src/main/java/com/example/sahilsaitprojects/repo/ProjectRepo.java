package com.example.sahilsaitprojects.repo;

import com.example.sahilsaitprojects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
