package booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Model Not Found")
public class ModelNotFoundException extends Exception {

    public ModelNotFoundException(String name) {
        super("Model Not Found with name=" + name);
    }
}
