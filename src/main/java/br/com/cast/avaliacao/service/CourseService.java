package br.com.cast.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.cast.avaliacao.model.Course;
import br.com.cast.avaliacao.repository.CourseRopository;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private CourseRopository repository;

	@Override
	public List<Course> findAll() {
			return (List<Course>) repository.findAll();
	}

	@Override
	public Course save(Course course) {
			return repository.save(course);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Course> findCourseByStartAndEndDate(String startDate, String endDate) {
		return repository.findCourseByStartAndEndDate(startDate, endDate);
	}
}
