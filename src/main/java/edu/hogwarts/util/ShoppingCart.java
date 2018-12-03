package edu.hogwarts.util;

import edu.hogwarts.persistence.entity.Course;
import edu.hogwarts.persistence.entity.CourseMaterial;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {

    private Set<Course> courses = new HashSet<Course>();
    private Map<CourseMaterial, Integer> courseMaterials = new HashMap<CourseMaterial, Integer>();

    public int getNumberOfItems() {
        return courses.size() + courseMaterials.values().stream().mapToInt(i -> i.intValue()).sum();
    }

    public Set<Course> getCourses() {
        return new HashSet<Course>(courses);
    }

    public Map<CourseMaterial, Integer> getCourseMaterials() {
        return new HashMap<CourseMaterial, Integer>(courseMaterials);
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

    public void updateQuantity(CourseMaterial courseMaterial, Integer quantity) {
        if (quantity <= 0) {
            courseMaterials.remove(courseMaterial);
        } else {
            courseMaterials.put(courseMaterial, quantity);
        }
    }

    public boolean hasCourseMaterial(CourseMaterial courseMaterial) {
        return courseMaterials.containsKey(courseMaterial);
    }

}
