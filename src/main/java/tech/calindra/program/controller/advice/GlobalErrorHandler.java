package tech.calindra.program.controller.advice;

import java.util.Map;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, Object>> validationExceptionHandler(MethodArgumentNotValidException e) {
        var errors = e.getBindingResult()
            .getAllErrors()
            .stream()
            .map(this::formatError);

        return new ResponseEntity<>(Map.of("errors", errors), HttpStatus.BAD_REQUEST);
    }

    private Map<String, String> formatError(ObjectError error) {
        return Map.of(
            "field", Objects.requireNonNull(error.getCodes())[0],
            "message", Objects.requireNonNull(error.getDefaultMessage()));
    }
}
