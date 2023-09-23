package systemDao;

import model.Doctor;

import java.util.List;

public interface DoctorDao {
    Doctor findDoctorById(Long id);

    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id);

}
