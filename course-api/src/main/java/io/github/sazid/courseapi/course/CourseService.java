package io.github.sazid.courseapi.course;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> getAllCourses(String topicId) {
        val courses = new ArrayList<Course>();
        repo.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return repo.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        repo.save(course);
    }

    public void updateCourse(Course course) {
        repo.save(course);
    }

    public void deleteCourse(String id) {
        repo.deleteById(id);
    }
}
