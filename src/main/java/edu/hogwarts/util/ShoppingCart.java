package edu.hogwarts.util;

import java.util.ArrayList;
import java.util.List;

import edu.hogwarts.persistence.entity.Course;

public class ShoppingCart {
	
	private List<Course> courses = new ArrayList<Course>();
	private List<Course> courseMaterials = new ArrayList<Course>();
	
	public int getNumberOfItems() {
		return courses.size() + courseMaterials.size();
	}

}
