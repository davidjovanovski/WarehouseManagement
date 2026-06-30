package personal.warehousemanagementsystem.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(Long id) {
        super(String.format("Article with id: %d not found", id));
    }

}
