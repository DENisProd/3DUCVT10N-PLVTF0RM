package ru.denis.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.shop.models.*;
import ru.denis.shop.models.users.Student;
import ru.denis.shop.models.users.Teacher;
import ru.denis.shop.payload.request.*;
import ru.denis.shop.payload.response.*;
import ru.denis.shop.repository.*;

import java.util.*;

@Service
@AllArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final FacultyRepository facultyRepository;
    private final CathedraRepository cathedraRepository;
    public final SpecialityRepository specialityRepository;
    public final StudentRepository studentRepository;
    public final AcademicGroupRepository academicGroupRepository;
    public final TeacherRepository teacherRepository;
    public final EventRepository eventRepository;

    @Transactional
    public ResponseEntity createFaculty (FacultyCreateRequest facultyCreateRequest) {
        User dean = userRepository.findById(facultyCreateRequest.deanId).get();
        dean.getRoles().add(roleRepository.findByName(ERole.ROLE_DEAN).get());
        userRepository.save(dean);

        List<Cathedra> cathedraList = new ArrayList<>();

        if (facultyCreateRequest.cathedraList!=null)
            for (Long id: facultyCreateRequest.cathedraList)
                cathedraList.add(cathedraRepository.findById(id).get());

        Faculty faculty = new Faculty(facultyCreateRequest, dean, cathedraList);
        facultyRepository.save(faculty);

        return new ResponseEntity<>(new FacultyResponse(faculty), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity setDean(Long facultyId, Long deanId) {
        User dean = userRepository.findById(deanId).get();
        dean.getRoles().add(new Role(ERole.ROLE_DEAN));
        userRepository.save(dean);

        Faculty faculty = facultyRepository.findById(facultyId).get();
        faculty.setDean(dean);
        facultyRepository.save(faculty);

        return new ResponseEntity<>(new FacultyResponse(faculty), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity createCathedra (CathedraCreateRequest cathedraCreateRequest) {
        User cathedraManager = userRepository.findById(cathedraCreateRequest.zavCathedra).get();
        cathedraManager.getRoles().add(roleRepository.findByName(ERole.ROLE_CATHEDRA_MAN).get());
        userRepository.save(cathedraManager);

        List<User> teacherList = new ArrayList<>();

        if (cathedraCreateRequest.teachers!=null)
            for (Long id: cathedraCreateRequest.teachers)
                teacherList.add(userRepository.findById(id).get());

        Faculty faculty = facultyRepository.findById(cathedraCreateRequest.faculty).get();

        Cathedra cathedra = new Cathedra(cathedraCreateRequest, cathedraManager, faculty, teacherList);
        cathedraRepository.save(cathedra);
        faculty.cathedraList.add(cathedra);
        facultyRepository.save(faculty);

        return new ResponseEntity<>(new CathedraResponse(cathedra), HttpStatus.CREATED);
    }

    public ResponseEntity createSpeciality(SpecialityCreateRequest specialityCreateRequest) {
        Cathedra cathedra = cathedraRepository.findById(specialityCreateRequest.cathedraId).get();
        Speciality speciality = new Speciality(specialityCreateRequest, cathedra);
        specialityRepository.save(speciality);
        cathedra.getSpecialityList().add(speciality);
        cathedraRepository.save(cathedra);

        return new ResponseEntity<>(new SpecialityResponse(speciality), HttpStatus.CREATED);
    }

    public ResponseEntity createStudent(StudentCreateRequest studentCreateRequest) {
        User candidate = userRepository.findById(studentCreateRequest.userId).get();
        AcademicGroup academicGroup = academicGroupRepository.findById(studentCreateRequest.academicGroup).get();
        Student student = new Student(candidate, studentCreateRequest.recordNumber, academicGroup);

        studentRepository.save(student);

        return new ResponseEntity<>(new StudentResponse(student), HttpStatus.CREATED);
    }

    public ResponseEntity createTeacher(TeacherCreateRequest teacherCreateRequest) {
        User candidate = userRepository.findById(teacherCreateRequest.userId).get();
        Teacher teacher = new Teacher(candidate, teacherCreateRequest.education, teacherCreateRequest.degree);

        teacherRepository.save(teacher);
        return new ResponseEntity<>(new TeacherResponse(teacher), HttpStatus.CREATED);
    }

    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> filteredUsers = new ArrayList<>();

        for(User user: users)
            filteredUsers.add(new UserResponse(user));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity changeUserInformation(UserChangeRequest userChangeRequest) {
        User user = userRepository.findById(userChangeRequest.id).get();

        Set<Role> roles = new HashSet<>();
        for(RoleRequest str: userChangeRequest.roles) {
            if(Objects.equals(str.name, "ROLE_USER")) roles.add(roleRepository.findByName(ERole.ROLE_USER).get());
            else if(Objects.equals(str.name, "ROLE_MODERATOR")) roles.add(roleRepository.findByName(ERole.ROLE_MODERATOR).get());
            else if(Objects.equals(str.name, "ROLE_ADMIN")) roles.add(roleRepository.findByName(ERole.ROLE_ADMIN).get());
            else if(Objects.equals(str.name, "ROLE_DEAN")) roles.add(roleRepository.findByName(ERole.ROLE_DEAN).get());
            else if(Objects.equals(str.name, "ROLE_CATHEDRA_MAN")) roles.add(roleRepository.findByName(ERole.ROLE_CATHEDRA_MAN).get());
            else if(Objects.equals(str.name, "ROLE_LEADER")) roles.add(roleRepository.findByName(ERole.ROLE_LEADER).get());
            else if(Objects.equals(str.name, "ROLE_STUDENT")) roles.add(roleRepository.findByName(ERole.ROLE_STUDENT).get());
            else if(Objects.equals(str.name, "ROLE_TEACHER")) roles.add(roleRepository.findByName(ERole.ROLE_TEACHER).get());
            else if(Objects.equals(str.name, "ROLE_UCHEB_OTDEL")) roles.add(roleRepository.findByName(ERole.ROLE_UCHEB_OTDEL).get());
        }

        user.change(userChangeRequest, roles);
        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity moderateEvent(Integer moderateState, Long eventId) {
        Event event = eventRepository.getById(eventId);
        event.setIsModerated(moderateState==1);

        eventRepository.save(event);

        return new ResponseEntity<>(new EventResponse(event), HttpStatus.OK);
    }


}
