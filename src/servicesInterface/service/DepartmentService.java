package servicesInterface.service;

import dataBase.DataBase;
import model.Department;
import systemDao.DepartmentDao;
import servicesInterface.DepartmentInterface;

import java.util.List;

public class DepartmentService implements DepartmentInterface {

    private final DepartmentDao departmentDao;
    private final DataBase dataBase;

    public DepartmentService(DepartmentDao departmentDao, DataBase dataBase) {
        this.departmentDao = departmentDao;
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }
    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }
}
