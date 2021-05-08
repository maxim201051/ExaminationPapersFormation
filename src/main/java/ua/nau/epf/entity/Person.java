package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name", "patronymic"})})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String patronymic;
    @ElementCollection
    private List<String> contactEmails;
    @ElementCollection
    private List<String> contactPhones;
    private String otherContactInfo;
    @OneToOne(fetch = FetchType.LAZY)
    private User account;
}
