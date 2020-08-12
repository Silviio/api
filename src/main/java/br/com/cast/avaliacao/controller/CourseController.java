package br.com.cast.avaliacao.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.cast.avaliacao.model.Course;
import br.com.cast.avaliacao.response.CourseException;
import br.com.cast.avaliacao.service.ICourseService;

@RestController
@RequestMapping("/v1/api")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/courses")
	ResponseEntity<List<Course>> getAllCourses() {
		return new ResponseEntity<List<Course>>(courseService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/course")
	public ResponseEntity<Course> create(@RequestBody Course course){
	   
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		//Regra de negócio 1
		//Verifica se existe(m) curso(s) cadastrado dentro do período informado
	    var courses = courseService.findCourseByStartAndEndDate(
			   dmyFormat.format(course.getStartDate()), 
			   dmyFormat.format(course.getEndDate()));
	    
	    if(courses.size() >= 1)
	    	throw new CourseException("Existe(m) curso(s) planejados(s) dentro do período informado");
		
	   return new ResponseEntity<Course>(courseService.save(course), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/courses/{id}")
	public void delete(@PathVariable long id) {
	    courseService.deleteById(id);
	}
}
