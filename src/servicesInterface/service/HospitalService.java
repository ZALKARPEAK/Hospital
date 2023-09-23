package servicesInterface.service;

import dataBase.DataBase;
import systemDao.HospitalDao;
import model.Hospital;
import model.Patient;
import servicesInterface.HospitalInterface;

import java.util.List;
import java.util.Map;

public class HospitalService implements HospitalInterface {
    private final HospitalDao hospitalDao;

    private final DataBase dataBase;

    public HospitalService(HospitalDao hospitalDao, DataBase dataBase) {
        this.hospitalDao = hospitalDao;
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
