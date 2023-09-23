package systemDao.daoImpl;

import dataBase.DataBase;
import model.Hospital;
import systemDao.PatientDao;
import model.Patient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientDaoImpl implements PatientDao {
    private final DataBase dataBase;

    public PatientDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        List<Hospital> patients1 = dataBase.getHospitals();

        List<Hospital> optionalHospital = patients1.stream().
                filter(hospital -> {
                    if (hospital.getId3() == id) {
                        List<Patient> hospitalPatients = hospital.getPatients();
                        hospitalPatients.addAll(patients);
                        dataBase.setHospitals(patients1);
                    }else{
                        System.out.println("Данный Hospital не найден");
                    }
                    return false;
                }).toList();
        System.out.println(optionalHospital);
        return "Добавлен";
    }

    @Override
    public Patient getPatientById(Long id) {
        return dataBase.getPatients().stream().filter(n -> n.getId4() == id).findFirst().orElse(null);
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        List<Patient> patients = dataBase.getPatients();

        return patients.stream()
                .collect(Collectors.groupingBy(Patient::getAge));
    }
}
