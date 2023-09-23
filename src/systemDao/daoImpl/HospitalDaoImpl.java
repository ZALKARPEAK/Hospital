package systemDao.daoImpl;

import dataBase.DataBase;
import systemDao.HospitalDao;
import model.Hospital;
import model.Patient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

public class HospitalDaoImpl implements HospitalDao {
    private final DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        List<Hospital> hospitals = dataBase.getHospitals();
        List<Hospital> collect = Collections.singletonList(hospitals.stream().
                filter(n -> !n.getDepartments().contains(hospital)).
                findFirst().orElse(null));

        hospitals.add(hospital);
        dataBase.setHospitals(hospitals);
        return "Успешно добавлен";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();

        return hospitals.stream()
                .filter(hospital -> hospital.getId3() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();
        return hospitals.stream()
                .filter(hospital -> hospital.getId3() == id)
                .findFirst()
                .map(Hospital::getPatients)
                .orElse(null);
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();
        hospitals.removeIf(n -> n.getId3() == id);
        return "Успешно удален Hospital";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        List<Hospital> hospitals = dataBase.getHospitals();

        return hospitals.stream().
                filter(n -> n.getAddress().contains(address)).
                collect(Collectors.toMap(Hospital::getHospitalName, hospital -> hospital));
    }
}
