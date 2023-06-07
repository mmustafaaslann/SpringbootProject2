package org.mustafa.aslan.service;

import org.mustafa.aslan.dto.UserDto;
import org.mustafa.aslan.entity.Address;
import org.mustafa.aslan.entity.User;
import org.mustafa.aslan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    return new UserDto(
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            user.getGrade(),
                            user.getDob()

                    );
                }).collect(Collectors.toList());
    }

    public void addANewUser(User user) {
        Optional<User> userOptional = userRepository.findStudentByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long studentId) {
        boolean exists = userRepository.existsById(studentId);
        if (!exists)
            throw new IllegalStateException("User with id " + studentId + " does not exists");
        userRepository.deleteById(studentId);
    }

    @Transactional
    public void updateUser(User userToUpdate) {
        Optional<User> userOptional = userRepository.findStudentByEmail(userToUpdate.getEmail());
        Optional<User> user = userRepository.findById(userToUpdate.getId());
        if (user.isPresent()) {
            if (userOptional.get().getId() != userToUpdate.getId() && Objects.equals(userOptional.get().getEmail(), userToUpdate.getEmail())) {
                throw new IllegalStateException("Email is taken");
            }
            if (user.get().getFirstName() != null && user.get().getFirstName().length() > 0) {
                user.get().setFirstName(userToUpdate.getFirstName());
            }
            if (user.get().getLastName() != null && user.get().getLastName().length() > 0) {
                user.get().setLastName(userToUpdate.getLastName());
            }
            if (user.get().getGrade() > 0) {
                user.get().setGrade(userToUpdate.getGrade());
            }
            if (user.get().getDob() != null) {
                user.get().setDob(userToUpdate.getDob());
            } else {
                throw new IllegalStateException("User with id " + userToUpdate.getId() + " does not exists");
            }
        }
    }

    /*
    @Transactional
    public void updateUser(Long userId, String name, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalStateException("User with id " + userId + " does not exists"));
        if (name != null && name.length()>0 && !Objects.equals(user.getFirstName(), name)){
            user.setFirstName(name);
        }

        if (email != null && email.length()>0 && !Objects.equals(user.getFirstName(), name)){
            Optional<User> userOptional = userRepository.findStudentByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            user.setEmail(name);
        }
    }

     */
    @Autowired
    private UserRepository UserRepository;

    public void saveUserWithAddress(User user, Address address) {
        user.setAddress(address);
        userRepository.save(user);
    }
}
