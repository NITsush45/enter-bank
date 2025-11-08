package dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String initialPassword;
    private String role; // Will be either "EMPLOYEE" or "ADMIN"

}