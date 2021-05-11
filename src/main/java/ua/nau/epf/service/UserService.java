package ua.nau.epf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.nau.epf.dto.StudentUserDTO;
import ua.nau.epf.dto.TeacherUserDTO;
import ua.nau.epf.dto.UserDTO;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.mapper.UserMapper;
import ua.nau.epf.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private static final String USER_DEFAULT_PROFILE_PICTURE_PATH = "/profile_pictures/standard_profile_picture.png";
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public StudentUserDTO addUser(StudentUserDTO studentUserDTO) {
        studentUserDTO.setUser(saveUser(studentUserDTO.getUser()));
        studentUserDTO.getStudent().setAccountId(studentUserDTO.getUser().getId());
        return studentUserDTO;
    }

    public TeacherUserDTO addUser(TeacherUserDTO teacherUserDTO) {
        teacherUserDTO.setUser(saveUser(teacherUserDTO.getUser()));
        teacherUserDTO.getTeacher().setAccountId(teacherUserDTO.getUser().getId());
        return teacherUserDTO;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return UserMapper.mapEntityToDto(userRepository.save(fillUserWithDefaultValuesOnCreation(userDTO)));
    }

    public User fillUserWithDefaultValuesOnCreation(UserDTO userDTO) {
        User user = UserMapper.mapDtoToEntity(userDTO);
        user.setProfilePictureFileName(USER_DEFAULT_PROFILE_PICTURE_PATH);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user " + username + " was not found!"));
    }
}
