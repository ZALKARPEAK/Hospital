package servicesInterface.service;

import dataBase.DataBase;
import model.Hospital;
import systemDao.DoctorDao;
import model.Doctor;
import servicesInterface.DoctorInterface;

import java.util.List;
import java.util.Objects;

public class DoctorService implements DoctorInterface {
    private final DoctorDao doctorDao;
    private final DataBase dataBase;

    public DoctorService(DoctorDao doctorDao, DataBase dataBase) {
        this.doctorDao = doctorDao;
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }
    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }
    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }

    //works here
    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        List<Doctor> doctors= doctorsId.stream().
                map(this::findDoctorById).
                filter(Objects::nonNull).toList();

        List<Hospital> hospitals = dataBase.getHospitals();
        hospitals.stream().flatMap(n -> n.getDepartments().stream()).
                filter(n -> n.getId() == departmentId).findFirst().
                ifPresent(n -> n.getDoctors().addAll(doctors));
        return "Успешно добавлен ";
    }

}
