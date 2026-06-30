package personal.warehousemanagementsystem.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(Long id) {
        super(String.format("Company with id: %d not found", id));
    }
}
