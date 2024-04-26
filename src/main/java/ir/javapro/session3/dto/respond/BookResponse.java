package ir.javapro.session3.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BookResponse {
    private final Long id;
    private final String name;
    private final long price;
}
