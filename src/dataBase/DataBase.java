package dataBase;

import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.List;

public class DataBase {
    private final List<Department> departments;
    private final List<Doctor> doctors;
    private List<Hospital> hospitals;
    private final List<Patient> patients;

    public DataBase(List<Department> departments, List<Doctor> doctors, List<Hospital> hospitals, List<Patient> patients) {
        this.departments = departments;
        this.doctors = doctors;
        this.hospitals = hospitals;
        this.patients = patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
