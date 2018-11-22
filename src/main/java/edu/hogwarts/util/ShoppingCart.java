package edu.hogwarts.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.CourseMaterial;

public class ShoppingCart {
	
	private Set<Course> courses = new HashSet<Course>();
	private Map<CourseMaterial, Integer> courseMaterials = new HashMap<CourseMaterial, Integer>();
	
	public int getNumberOfItems() {
		return courses.size() + courseMaterials.keySet().size();
	}
	
	public void add(Course course) {
		courses.add(course);
	}
	
	public void remove(Course course) {
		courses.remove(course);
	}
	
	public boolean hasCourse(Course course) {
		return courses.contains(course);
	}
	
	public void add(CourseMaterial courseMaterial) {
		if (courseMaterials.containsKey(courseMaterial)) {
			courseMaterials.put(courseMaterial, courseMaterials.get(courseMaterial).intValue() + 1);
		} else {
			courseMaterials.put(courseMaterial, 1);
		}
		
	}
	
	public void remove(CourseMaterial courseMaterial) {
		courseMaterials.remove(courseMaterial);
	}
	
	public boolean hasCourseMaterial(CourseMaterial courseMaterial) {
		return courseMaterials.containsKey(courseMaterial);
	}

}
