package br.com.cast.avaliacao.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CourseException(String exception) {
		    super(exception);
		  }
}
