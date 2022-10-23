package ru.denis.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.shop.models.*;
import ru.denis.shop.payload.response.CathedraResponse;
import ru.denis.shop.payload.response.FacultyResponse;
import ru.denis.shop.payload.response.SpecialityResponse;
import ru.denis.shop.repository.CathedraRepository;
import ru.denis.shop.repository.FacultyRepository;
import ru.denis.shop.repository.SpecialityRepository;
import ru.denis.shop.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeanService {

    private final UserRepository userRepository;
    private final FacultyRepository facultyRepository;
    private final CathedraRepository cathedraRepository;
    private final SpecialityRepository specialityRepository;

    public ResponseEntity fetchAll() {
        List<Faculty> facultyList = facultyRepository.findAll();
        List<FacultyResponse> filteredFaculties = new ArrayList<>();

        for (Faculty faculty: facultyList)
            filteredFaculties.add(new FacultyResponse(faculty));

        return new ResponseEntity<>(filteredFaculties, HttpStatus.OK);
    }

    public ResponseEntity fetchAllCathedra() {
        List<Cathedra> cathedraList = cathedraRepository.findAll();
        List<CathedraResponse> filteredCathedras = new ArrayList<>();

        for (Cathedra cathedra: cathedraList)
            filteredCathedras.add(new CathedraResponse(cathedra));

        return new ResponseEntity<>(filteredCathedras, HttpStatus.OK);
    }

    public ResponseEntity fetchAllCathedrasByFaculty(Long facultyId) {
        List<Cathedra> cathedraList = cathedraRepository.findCathedraByFac(facultyId);
        List<CathedraResponse> filteredCathedras = new ArrayList<>();

        for(Cathedra cathedra: cathedraList)
            filteredCathedras.add(new CathedraResponse(cathedra));

        return new ResponseEntity<>(filteredCathedras, HttpStatus.OK);
    }

    public ResponseEntity fetchAllSpecialitiesByCathedra(Long cathedraId) {
        List<Speciality> specialities = specialityRepository.getAllByCathedra_Id(cathedraId);
        List<SpecialityResponse> filteredSpecialities = new ArrayList<>();

        for (Speciality speciality: specialities)
            filteredSpecialities.add(new SpecialityResponse(speciality));

        return new ResponseEntity<>(filteredSpecialities, HttpStatus.OK);
    }

}
