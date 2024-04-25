package ir.javapro.session3.dto.respond;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    private final String message;
    private final String code;
}
