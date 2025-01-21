package org.backendlld.bookmyshow.services;

import org.backendlld.bookmyshow.dtos.ResponseStatus;
import org.backendlld.bookmyshow.dtos.SignInResponseDto;
import org.backendlld.bookmyshow.dtos.SignUpRequestDto;
import org.backendlld.bookmyshow.dtos.SignUpResponseDto;
import org.backendlld.bookmyshow.models.User;
import org.backendlld.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpResponseDto SignUp(SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto =  new SignUpResponseDto();
        try {
            Optional<User> optionalUser = userRepository.getUserByEmailOrPhoneNumber(signUpRequestDto.getEmail(), signUpRequestDto.getPhoneNumber());
            if (optionalUser.isPresent()) {
                throw new RuntimeException("User already exists");
            }
            User user = new User();
            user.setEmail(signUpRequestDto.getEmail());
            user.setPhone(signUpRequestDto.getPhoneNumber());
            user.setName(signUpRequestDto.getName());
            user.setPassword(signUpRequestDto.getPassword());
            int userId = userRepository.save(user).getId();

            signUpResponseDto.setUserId(userId);
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        }
        return signUpResponseDto;
    }

    public SignInResponseDto SignIn(SignUpRequestDto signUpRequestDto) {
        SignInResponseDto signInResponseDto = new SignInResponseDto();
        try{
            Optional<User> optionalUser = userRepository.getUserByEmailAndPassword(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            if (optionalUser.isEmpty()) {
                throw new RuntimeException("Email or password is incorrect");
            }
           signInResponseDto.setUserId(optionalUser.get().getId());
            signInResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (RuntimeException e) {
            signInResponseDto.setStatus(ResponseStatus.FAILURE);
        }
      return signInResponseDto;
    }
}
