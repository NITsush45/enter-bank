package dto;


import entity.User;
import enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private List<String> roles;


    public EmployeeDTO(User user, List<String> roles) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.roles = roles;
    }

}