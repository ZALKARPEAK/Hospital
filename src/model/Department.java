package model;

import java.util.List;

public class Department {
    private static int idd = 1;
    private int id;
    private final String departmentName;
    private final List<Doctor> doctors;

    public Department(String departmentName, List<Doctor> doctors) {
        this.id = idd++;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
