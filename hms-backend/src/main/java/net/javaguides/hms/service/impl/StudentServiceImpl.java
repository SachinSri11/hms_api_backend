package net.javaguides.hms.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.hms.dto.StudentDto;
import net.javaguides.hms.entity.Student;
import net.javaguides.hms.exception.ResourceNotFoundException;
import net.javaguides.hms.mapper.StudentMapper;
import net.javaguides.hms.repository.StudentRepository;
import net.javaguides.hms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= StudentMapper.mapToStudent(studentDto);
        Student savedStudent=studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student=studentRepository.findById(studentId).
                orElseThrow(()->
                        new ResourceNotFoundException("Student not found with id : "+studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student does not exist with given Id: "+studentId));
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setPhone(updatedStudent.getPhone());
        Student updatedStudentobj=studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentobj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student does not exist with given Id: "+studentId));
        studentRepository.deleteById(studentId);
    }


}
