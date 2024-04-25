package ir.javapro.session3.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserRespond {

    private final Long id;
    private final String username;

}
