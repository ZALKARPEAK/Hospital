package servicesInterface;

import model.Doctor;

import java.util.List;

public interface DoctorInterface {
    Doctor findDoctorById(Long id);

    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);

    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
