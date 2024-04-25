package ir.javapro.session3.service.user;

import ir.javapro.session3.dto.request.UserRequest;
import ir.javapro.session3.dto.respond.UserRespond;
import ir.javapro.session3.exeption.RuleException;
import ir.javapro.session3.model.User;
import ir.javapro.session3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRespond save(UserRequest userRequest) {
        Optional<User> byUsername =
                userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent())
            throw new RuleException("Username.Is.Exist");
        return createUserRespond(userRepository.save(createUser(userRequest)));
    }

    private UserRespond createUserRespond(User user) {
        return UserRespond.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    private User createUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();
    }
}
