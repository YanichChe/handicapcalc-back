package ru.chernovskaya.handicapcalc.controller.api.v0;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.RequestContextUtils;
import ru.chernovskaya.handicapcalc.dto.ErrorDto;

import java.time.Instant;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionCatcher {
    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException e) {
        var errors =
                e.getBindingResult().getFieldErrors().stream()
                        .collect(
                                Collectors.groupingBy(
                                        FieldError::getField,
                                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.joining(" "))));

        return ResponseEntity.status(BAD_REQUEST)
                .body(
                        ErrorDto.builder()
                                .createdAt(Instant.now())
                                .message(getMessage("exception.validation-error", request))
                                .errors(errors)
                                .build());
    }

    private String getMessage(String code, HttpServletRequest request) {
        return messageSource.getMessage(code, null, RequestContextUtils.getLocale(request));
    }
}
