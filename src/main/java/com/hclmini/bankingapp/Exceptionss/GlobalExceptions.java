package com.hclmini.bankingapp.Exceptionss;

import com.hclmini.bankingapp.Entity.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class )
        public Map<String,String>handelMethodArgumentNotValid(MethodArgumentNotValidException exc){
            Map<String,String> errors=new HashMap<>();
            exc.getBindingResult().getFieldErrors()
                    .forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
            return errors;
        }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handelConstraintViolationException(ConstraintViolationException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getConstraintViolations().forEach(cv->{
            errors.put("message",cv.getMessage());
            errors.put("path",(cv.getPropertyPath()).toString());
                });
               return errors;
    }


   /* @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handelException(CustomerNumberInvalidException exc){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage(exc.getMessage());
        exceptionResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }*/


}
