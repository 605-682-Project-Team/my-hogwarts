package edu.hogwarts.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseMaterial {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
}
