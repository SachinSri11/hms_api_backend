package net.javaguides.hms.mapper;

import net.javaguides.hms.dto.StudentDto;
import net.javaguides.hms.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getPhone()
        );
    }

    public static Student mapToStudent(StudentDto studentDto)
    {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getPhone()

        );
    }
}
