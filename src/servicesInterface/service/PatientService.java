package servicesInterface.service;

import dataBase.DataBase;
import systemDao.PatientDao;
import model.Patient;
import servicesInterface.PatientInterface;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientService implements PatientInterface {
    private final PatientDao patientDao;
    private final DataBase dataBase;

    public PatientService(PatientDao patientDao, DataBase dataBase) {
        this.patientDao = patientDao;
        this.dataBase = dataBase;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    //works here
    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = dataBase.getPatients();

        Comparator<Patient> comparator = Comparator.comparing(Patient::getAge);

        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            comparator = comparator.reversed();
        }

        return patients.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
