package com.mintifi.companyapi.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorDetailProblemHandlingControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ProblemDetail onException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatusCode.valueOf(400), "Invalid request content.");
        problemDetail.setTitle("Constraint Violation");
        List<ApiValidationError> validationErrorsList =
                methodArgumentNotValidException.getAllErrors().stream()
                        .map(
                                objectError -> {
                                    FieldError fieldError = (FieldError) objectError;
                                    return new ApiValidationError(
                                            fieldError.getObjectName(),
                                            fieldError.getField(),
                                            fieldError.getRejectedValue(),
                                            Objects.requireNonNull(fieldError.getDefaultMessage()));
                                })
                        .toList();
        problemDetail.setProperty("violations", validationErrorsList);
        return problemDetail;
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ApiValidationError> handleGlobalException(GlobalException exception) {
        ApiValidationError response = new ApiValidationError();
        response.setMessage(exception.getMessage());
        response.setRejectedValue(exception.getStatus().value());
        return new ResponseEntity<>(response, exception.getStatus());
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiExceptionResponse> resourceNotFoundExceptionHandler(
        ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiExceptionResponse apiResponse = new ApiExceptionResponse(message);
        return new ResponseEntity<ApiExceptionResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiExceptionResponse> dataIntegrityViolationException(
        ConstraintViolationException ex) {
        ProblemDetail problemDetail =
            ProblemDetail.forStatusAndDetail(
                HttpStatusCode.valueOf(400), "Invalid request content.");

        String message = ex.getMessage();
        String patternString = "messageTemplate='(.*?)'";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String messageTemplate = matcher.group(1);
            message = messageTemplate;
            System.out.println("Extracted messageTemplate: " + messageTemplate);
        } else {
            System.out.println("No messageTemplate found.");
        }
        ApiExceptionResponse apiResponse = new ApiExceptionResponse(message);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ApiValidationError {

        private String object;

        private String field;

        private Object rejectedValue;

        private String message;

        ApiValidationError(String object, String message) {
            this.object = object;
            this.message = message;
        }

        ApiValidationError(String message) {
            this.message = message;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class ApiExceptionResponse {

        private String message;
    }

}
