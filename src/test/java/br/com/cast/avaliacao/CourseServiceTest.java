package br.com.cast.avaliacao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cast.avaliacao.model.Category;
import br.com.cast.avaliacao.model.Course;
import br.com.cast.avaliacao.repository.CourseRopository;
import br.com.cast.avaliacao.service.CourseService;

@SpringBootTest
class CourseServiceTest {

	@Autowired
	private CourseRopository courseRepository;

	@Autowired
	private CourseService courseService;

	@Test
	void deleteCourse() {

		Category category = new Category("Programação");
		category.setId(2L);
		Course course = new Course("TesteDelete", new Date(), new Date(), 3, category);
		courseRepository.save(course);
		courseService.deleteById(course.getId());

		var courses = (List<Course>) courseService.findAll();

		assertEquals(courses.size(), 0);

	}

	@Test
	void getAllCourses() {

		Category category = new Category("Comportamental");
		category.setId(1L);
		Course course = new Course("Teste", new Date(), new Date(), 3, category);
		courseRepository.save(course);

		var firstCourse = ((List<Course>) courseService.findAll()).get(0);

		assertEquals(course.getId(), firstCourse.getId());

	}

}
