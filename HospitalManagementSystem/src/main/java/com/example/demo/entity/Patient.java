package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;

    private LocalDate dateOfBirth;

    private String address;

    private String bloodGroup;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Appointment> appointments = new ArrayList<>();

//ID
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

// Name
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

// Email
public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

// Phone
public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

// Date of Birth
public LocalDate getDateOfBirth() {
    return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}

// Address
public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

// Blood Group
public String getBloodGroup() {
    return bloodGroup;
}

public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
}

// Appointments (OneToMany Relationship)
public List<Appointment> getAppointments() {
    return appointments;
}

public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
}
@Override
public String toString() {
    return "Patient{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", dob=" + dateOfBirth +
            ", bloodGroup='" + bloodGroup + '\'' +
            ", appointmentsCount=" + (appointments != null ? appointments.size() : 0) +
     '}';
}
}
