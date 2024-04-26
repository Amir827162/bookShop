package ir.javapro.session3.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class UserRequest {

    @NotNull(message = "{username.is.null}")
    @NotBlank(message = "{username.is.blank}")
    private String username ;
    @NotNull(message = "{password.is.null}")
    @NotBlank(message = "{password.is.blank}")
    private String password;
}
