package br.com.cast.avaliacao.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
	private Long id;
    
    @Column(name="description_subject")
	private String descriptionSubject;
    
    @Column(name="start_date")
	private Date startDate;
    
    @Column(name="end_date")
	private Date endDate;
    
    @Column(name="student_amount_per_class")
	private Integer studentAmountPerClass;
	
	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;
		
	public Course() {}
	
	public Course(String descriptionSubject, Date startDate, Date endDate, Integer studentAmountPerClass,
			Category category) {
		this.descriptionSubject = descriptionSubject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentAmountPerClass = studentAmountPerClass;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDescriptionSubject() {
		return descriptionSubject;
	}

	public void setDescriptionSubject(String descriptionSubject) {
		this.descriptionSubject = descriptionSubject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStudentAmountPerClass() {
		return studentAmountPerClass;
	}

	public void setStudentAmountPerClass(Integer studentAmountPerClass) {
		this.studentAmountPerClass = studentAmountPerClass;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
