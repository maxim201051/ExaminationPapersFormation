package ua.nau.epf.mapper;

import ua.nau.epf.dto.UserDTO;
import ua.nau.epf.entity.user.Role;
import ua.nau.epf.entity.user.User;

import java.util.Collections;

public class UserMapper {
    private UserMapper() {
    }

    public static UserDTO mapEntityToDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setProfilePictureFileName(entity.getProfilePictureFileName());
        dto.setAuthority(entity.getAuthorities().get(0).name());
        dto.setEnabled(entity.isEnabled());
        return dto;
    }

    public static User mapDtoToEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setProfilePictureFileName(dto.getProfilePictureFileName());
        entity.setAuthorities(Collections.singletonList(Role.valueOf(dto.getAuthority())));
        return entity;
    }
}
