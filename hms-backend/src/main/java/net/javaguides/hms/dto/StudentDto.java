package net.javaguides.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.hms.entity.Student;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String firstName;
    private String lastName;
    private long phone;

    public StudentDto(long id, String firstName, String lastName, long phone) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
