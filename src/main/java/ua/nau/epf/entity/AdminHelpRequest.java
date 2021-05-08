package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AdminHelpRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Person sender;
    @Column(nullable = false)
    private String requestText;
    @Column(nullable = false)
    private LocalDate creationDate;
    @Column(nullable = false)
    private Boolean resolved;
}
