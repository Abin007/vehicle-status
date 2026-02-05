package com.elitauto.vehicle.status.data.MongoObj;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 1, max = 50, message = "First Name must be between 1 and 50 characters")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 1, max = 50, message = "First Name must be between 1 and 50 characters")
    private String lastName;
    @NotBlank(message = "Phone Number cannot be blank")
    @Size(min = 10, max = 10, message = "Phone Number must be  10 characters")
    private String phoneNumber;
    @NotBlank(message = "Email Address cannot be blank")
    @Email(message = "Invalid email format")
    private String emailAddress;
}
