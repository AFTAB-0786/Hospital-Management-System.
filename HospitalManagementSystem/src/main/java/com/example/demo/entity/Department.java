
    package com.example.demo.entity;

    import java.util.*;

    import jakarta.persistence.CascadeType;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.Table;
    import jakarta.validation.constraints.NotBlank;
    import lombok.AllArgsConstructor;
    import lombok.Builder;

    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Entity
    @Table(name = "departments")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Department name is required")
        @Column(nullable = false, unique = true)
        private String name;

        private String description;

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
        @Builder.Default
        private List<Doctor> doctors = new ArrayList<>();

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        @Builder.Default
        private List<Appointment> appointments = new ArrayList<>();
    
 // ID
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

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Doctors List
    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    // Appointments List
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doctorsCount=" + (doctors != null ? doctors.size() : 0) +
                ", appointmentsCount=" + (appointments != null ? appointments.size() : 0) +
                '}';
    }
}
