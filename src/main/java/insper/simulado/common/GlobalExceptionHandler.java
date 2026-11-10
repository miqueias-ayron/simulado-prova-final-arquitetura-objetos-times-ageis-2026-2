package insper.simulado.common;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDTO handleValidationException(MethodArgumentNotValidException ex) {
        ErrorResponseDTO errors = new ErrorResponseDTO();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.getErrors().add(error.getDefaultMessage()));
        errors.setStatus(HttpStatus.BAD_REQUEST.value()); errors.setMessage("Erro de validação"); return errors;
    }
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handleRuntimeException(RuntimeException ex) {
        ErrorResponseDTO errors = new ErrorResponseDTO(); errors.setStatus(HttpStatus.NOT_FOUND.value()); errors.setMessage(ex.getMessage()); return errors;
    }
}
