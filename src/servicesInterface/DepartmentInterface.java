package servicesInterface;

import model.Department;

import java.util.List;

public interface DepartmentInterface {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}
