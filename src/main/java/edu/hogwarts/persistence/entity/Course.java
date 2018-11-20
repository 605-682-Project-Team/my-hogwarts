package edu.hogwarts.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String professor;
	
	private CourseCategory category;
	
//	private List<CourseMaterial> materials;
	
	public enum CourseCategory {
		CORE,
		ELECTIVE,
		EXTRA_CURRICULAR
	}

}
