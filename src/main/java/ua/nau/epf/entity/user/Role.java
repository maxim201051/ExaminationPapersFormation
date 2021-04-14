package ua.nau.epf.entity.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    TEACHER,
    STUDENT;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
