package ie.atu.lab5_validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Title cannot be blank")
    @Max(value = 5, message = "Title must be smaller or equal to 5 characters")
    private String title;

    @Size(min = 2, max = 10, message = "EmployeeId must be between 2 and 10 numbers")
    private int employeeId;

    @NotBlank(message = "Age cannot be blank")
    private int age;

    @NotBlank(message = "Position cannot be blank")
    private String position;

    @NotBlank(message = "Department cannot be blank")
    private String department;
}
