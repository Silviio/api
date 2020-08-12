package br.com.cast.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cast.avaliacao.model.Course;

@Repository
public interface CourseRopository extends CrudRepository<Course, Long>{
	
@Query( value = "SELECT * FROM courses c WHERE c.start_date >= ?1 AND c.end_date <= ?2",
		nativeQuery = true	)
List<Course> findCourseByStartAndEndDate(
 String startDate, 
 String endDate);
}
