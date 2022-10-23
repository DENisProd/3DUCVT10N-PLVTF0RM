package ru.denis.shop.services;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.denis.shop.models.Role;
import ru.denis.shop.models.User;
import ru.denis.shop.models.users.Student;
import ru.denis.shop.models.users.Teacher;
import ru.denis.shop.payload.response.StudentResponse;
import ru.denis.shop.payload.response.TeacherResponse;
import ru.denis.shop.payload.response.UserResponse;
import ru.denis.shop.repository.EmployeeRepository;
import ru.denis.shop.repository.StudentRepository;
import ru.denis.shop.repository.TeacherRepository;
import ru.denis.shop.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final StudentRepository studentRepository;
    public final EmployeeRepository employeeRepository;
    public final TeacherRepository teacherRepository;

    public ResponseEntity getProfile(UserDetailsImpl userImpl) {
        User user = userRepository.findById(userImpl.getId()).get();

        for (Role role : user.getRoles()) {
            if (role.getName().toString() == "ROLE_STUDENT") {
                Student student = studentRepository.getStudentByStudent_Id(userImpl.getId());
                return new ResponseEntity<>(new StudentResponse(student), HttpStatus.OK);
            } else if (role.getName().toString() == "ROLE_TEACHER") {
                Teacher teacher = teacherRepository.getTeacherByTeacher_Id(userImpl.getId());
                return new ResponseEntity<>(new TeacherResponse(teacher), HttpStatus.OK);
            }
//            } else if (role.getName().toString() == "ROLE_EMPLOYEE") {
//                hasEmployee = true;
//                //break;
//            }
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
