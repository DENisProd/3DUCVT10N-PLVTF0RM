package ru.denis.shop.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class UserChangeRequest {
    public Long id;
    public String username;
    @NotBlank
    @Size(max = 50)
    @Size(min = 2)
    @Email
    public String email;
    @Size(min = 2)
    public String firstName;
    public String lastName;
    public String patronomic;
    public List<RoleRequest> roles;
}
