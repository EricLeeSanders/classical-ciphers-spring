package com.ericleesanders.classicalciphers.web.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ericleesanders.classicalciphers.web.dto.error.ErrorResourceDTO;
import com.ericleesanders.classicalciphers.web.dto.error.FieldErrorResourceDTO;
import com.ericleesanders.classicalciphers.web.exception.InvalidRequestException;

@ControllerAdvice
public class CipherExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ InvalidRequestException.class })
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {

        InvalidRequestException ire = (InvalidRequestException) e;
        List<FieldErrorResourceDTO> fieldErrorResources = new ArrayList<>();

        for (Errors err : ire.getErrors()) {
            List<FieldError> fieldErrors = err.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                FieldErrorResourceDTO fieldErrorResource = new FieldErrorResourceDTO();
                fieldErrorResource.setResource(fieldError.getObjectName());
                fieldErrorResource.setField(fieldError.getField());
                fieldErrorResource.setCode(fieldError.getCode());
                fieldErrorResource.setMessage(fieldError.getDefaultMessage());
                fieldErrorResources.add(fieldErrorResource);
            }
        }

        ErrorResourceDTO error = new ErrorResourceDTO("InvalidRequest", ire.getMessage());
        error.setFieldErrors(fieldErrorResources);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
