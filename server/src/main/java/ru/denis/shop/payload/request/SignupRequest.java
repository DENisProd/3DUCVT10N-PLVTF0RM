package ru.denis.shop.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Size(min = 2)
    @Email
    private String email;
    @Size(min = 2)
    private String firstName;
    private String lastName;
    private String patronomic;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
