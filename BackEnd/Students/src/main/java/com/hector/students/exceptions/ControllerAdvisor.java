package com.hector.students.exceptions;

import com.hector.students.controller.dto.response.MessageRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor  {

    @ExceptionHandler({ BussinesException.class })
    public final ResponseEntity<MessageRespone> handleException(Exception ex, WebRequest request) {
        MessageRespone messageRespone = new MessageRespone();
        messageRespone.setError(ex.getMessage());
        return new ResponseEntity<>(messageRespone, HttpStatus.BAD_REQUEST);
    }

}
