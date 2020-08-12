DROP TABLE IF EXISTS categories;

CREATE TABLE categories(
    category_id int NOT NULL AUTO_INCREMENT,
    description varchar(255) NOT NULL,
    PRIMARY KEY (category_id)	
);


INSERT INTO categories(description)
VALUES
	('Comportamental'),
	('Programação'),
	('Qualidade'),
	('Processos');

DROP TABLE IF EXISTS courses;

CREATE TABLE courses(
    course_id int NOT NULL AUTO_INCREMENT,
    description_subject varchar(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    student_amount_per_class int DEFAULT 0,
    category_id int NOT NULL,
    PRIMARY KEY (course_id),
    CONSTRAINT fk_course_category FOREIGN KEY (category_id) REFERENCES categories(category_id)
);