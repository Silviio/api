package br.com.cast.avaliacao.service;

import java.util.List;

import br.com.cast.avaliacao.model.Course;

public interface ICourseService {

	public List<Course> findAll();
	
	public Course save(Course course);
	
	public void deleteById(Long id);
	
	public List<Course> findCourseByStartAndEndDate(String startDate, String endDate);
			
}
	

