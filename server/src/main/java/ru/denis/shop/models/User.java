package ru.denis.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.payload.request.UserChangeRequest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    //@NotBlank
    @Size(max = 20)
    private String firstName;

    //@NotBlank
    @Size(max = 20)
    private String lastName;

    @Size(max = 20)
    private String patronomic;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    private Integer balance = 0;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password, String firstName, String lastName, String patronomic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronomic = patronomic;
    }

    public void change(UserChangeRequest userChangeRequest, Set<Role> roles) {
        this.firstName = userChangeRequest.firstName;
        this.lastName = userChangeRequest.lastName;
        this.patronomic = userChangeRequest.patronomic;
        this.email = userChangeRequest.email;
        this.roles = roles;
    }
}
