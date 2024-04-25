package ir.javapro.session3.service.user;

import ir.javapro.session3.dto.request.UserRequest;
import ir.javapro.session3.dto.respond.UserRespond;

public interface UserService {

    UserRespond save(UserRequest userRequest);

}
