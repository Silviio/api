package br.com.cast.avaliacao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cast.avaliacao.model.Category;
import br.com.cast.avaliacao.model.Course;
import br.com.cast.avaliacao.service.ICourseService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
class CourseControllerTest {

    @MockBean
    private ICourseService courseService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllCourses() throws Exception 
    {
   	
        List<Course> courses = new ArrayList<Course>();
    	courses.add(new Course("Teste", new Date(), new Date(), 3, new Category("Programação")));
    	courses.add(new Course("Teste2", new Date(), new Date(), 3, new Category("Qualidade")));

    	when(courseService.findAll()).thenReturn(courses);
    	
    	mockMvc.perform( MockMvcRequestBuilders
          .get("/v1/api/courses")
          .accept(MediaType.APPLICATION_JSON))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").exists());
    }
    
    @Test
    public void createCourse() throws Exception 
    {
    	mockMvc.perform( MockMvcRequestBuilders
          .post("/v1/api/course")
          .content(toJsonString(new Course("Teste", new Date(), new Date(), 3, new Category("Programação"))))
          .contentType(MediaType.APPLICATION_JSON)
          .characterEncoding("utf-8")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated())
          .andDo(print());
    }
    
    @Test
    public void deleteCourse() throws Exception 
    {
    	mockMvc.perform( MockMvcRequestBuilders.delete("/v1/api/courses/{id}", 1) )
            .andExpect(status().isOk());
    }
    

    public static String toJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
       }
  
}
 
}
