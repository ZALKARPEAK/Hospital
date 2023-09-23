package model;

import java.util.List;

public class Hospital {
    private static int idd3 = 1;
    private final int id3;
    private final String hospitalName;
    private final String address;
    private final List<Department> departments;
    private final List<Doctor> doctors;
    private final List<Patient> patients;

    public Hospital(String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id3 = idd3++;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }


    public int getId3() {
        return id3;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "\nHospital - " +
                "id: " + id3 +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + "\n" +
                "Departments: " + departments + "\n" +
                "Patients: " + patients;
    }
}
