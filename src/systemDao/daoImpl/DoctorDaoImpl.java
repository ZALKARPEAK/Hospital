package systemDao.daoImpl;

import dataBase.DataBase;
import model.Department;
import model.Hospital;
import systemDao.DoctorDao;
import model.Doctor;

import java.util.List;
import java.util.Optional;

public class DoctorDaoImpl implements DoctorDao {
    private final DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return dataBase.getDoctors().stream().filter(n -> n.getId1() == id).findFirst().orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Hospital> doctors = dataBase.getHospitals();
        return doctors.stream().filter(n -> n.getId3() == id).map(Hospital::getDoctors) //hospital -> h.getDoctors
                .findFirst().orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        Optional<Department> optionalDoctor = dataBase.getDepartments().
                stream().filter(n -> n.getId() == id).findFirst();

        if (optionalDoctor.isPresent()) {
            return optionalDoctor.get().getDoctors();
        } else {
            System.out.println("Данный Department не найден");
            return null;
        }
    }
}
