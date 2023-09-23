package systemDao.daoImpl;

import dataBase.DataBase;
import systemDao.DepartmentDao;
import model.Department;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentDaoImpl implements DepartmentDao {
    private final DataBase dataBase;

    public DepartmentDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return dataBase.getDepartments().stream().filter(n -> n.getId() == id).collect(Collectors.toList());
    }

    @Override
    public Department findDepartmentByName(String name) {
        return dataBase.getDepartments().stream().
                filter(n -> n.getDepartmentName().equals(name)).findFirst().orElse(null);
    }
}
