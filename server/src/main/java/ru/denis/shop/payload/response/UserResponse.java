package ru.denis.shop.payload.response;

import ru.denis.shop.models.User;

import javax.validation.constraints.Size;

public class UserResponse {
    public Long id;
    public String email;
    private String firstName;
    private String lastName;
    private String patronomic;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.patronomic = user.getPatronomic();
    }
}
