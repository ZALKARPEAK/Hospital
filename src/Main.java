import dataBase.DataBase;
import gender.Gender;
import model.Department;
import model.Doctor;
import model.Hospital;
import model.Patient;
import servicesInterface.service.DepartmentService;
import servicesInterface.service.DoctorService;
import servicesInterface.service.HospitalService;
import servicesInterface.service.PatientService;
import systemDao.daoImpl.DepartmentDaoImpl;
import systemDao.daoImpl.DoctorDaoImpl;
import systemDao.daoImpl.HospitalDaoImpl;
import systemDao.daoImpl.PatientDaoImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //PATIENT
        Patient patient1 = new Patient("John", "Doe", 35, Gender.MALE);
        Patient patient2 = new Patient("Alice", "Smith", 42, Gender.FEMALE);
        Patient patient3 = new Patient("Robert", "Johnson", 28, Gender.MALE);
        Patient patient4 = new Patient("Emily", "Davis", 50, Gender.FEMALE);
        Patient newPatients = new Patient("newPatient", "Pat", 30, Gender.FEMALE);

        List<Patient> newPatient = new ArrayList<>();
        newPatient.add(newPatients);
        List<Patient> patients1 = new ArrayList<>();
        patients1.add(patient1);
        patients1.add(patient2);

        List<Patient> patients2 = new ArrayList<>();
        patients2.add(patient3);
        patients2.add(patient4);
        List<Patient> patientList = new ArrayList<>();
        patientList.addAll(patients1);
        patientList.addAll(patients2);

        //DOCTOR
        Doctor doctor1 = new Doctor("John", "Smith", Gender.MALE, 10);
        Doctor doctor2 = new Doctor("Alice", "Johnson", Gender.FEMALE, 5);
        Doctor doctor3 = new Doctor("Robert", "Davis", Gender.MALE, 15);
        Doctor doctor4 = new Doctor("Emily", "Brown", Gender.FEMALE, 8);
        Doctor newDoctor = new Doctor("newDoctor", "Doc", Gender.FEMALE, 12);
        List<Doctor> doctors1 = new ArrayList<>();
        doctors1.add(doctor2);
        doctors1.add(doctor1);
        List<Doctor> doctors2 = new ArrayList<>();
        doctors2.add(doctor3);
        doctors2.add(doctor4);
        List<Doctor> newDoctors = new ArrayList<>();
        newDoctors.add(newDoctor);

        List<Doctor> doctorList = new ArrayList<>();
        doctorList.addAll(doctors1);
        doctorList.addAll(doctors2);

        //DEPARTMENT
        Department department1 = new Department("Cardiology", doctors1);
        Department department2 = new Department("Orthopedics", doctors2);
        List<Department> departments1 = new ArrayList<>();
        departments1.add(department1);
        List<Department> departments2 = new ArrayList<>();
        departments2.add(department2);
        List<Department> departmentList = new ArrayList<>();
        departmentList.addAll(departments1);
        departmentList.addAll(departments2);

        List<Department> newDepartment = new ArrayList<>();
        Department newDepartments = new Department("NewDepartment", newDoctors);
        newDepartment.add(newDepartments);

        //HOSPITAL
        Hospital hospital1 = new Hospital("City General Hospital", "123 Main Street", departments1, doctors1, patients1);
        Hospital hospital2 = new Hospital("County Medical Center", "456 Oak Avenue", departments2, doctors2, patients2);
        List<Hospital> hospitals = new ArrayList<>(Arrays.asList(hospital1, hospital2));

        DataBase dataBase = new DataBase(departmentList, doctorList, hospitals, patientList);

        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(dataBase);
        DepartmentService departmentService = new DepartmentService(departmentDao, dataBase);

        DoctorDaoImpl doctorDao = new DoctorDaoImpl(dataBase);
        DoctorService doctorService = new DoctorService(doctorDao, dataBase);

        HospitalDaoImpl hospitalDao = new HospitalDaoImpl(dataBase);
        HospitalService hospitalService = new HospitalService(hospitalDao, dataBase);

        PatientDaoImpl patientDao = new PatientDaoImpl(dataBase);
        PatientService patientService = new PatientService(patientDao, dataBase);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Получить все Department по айди
                    2. Найти Department по имени
                    3. Найти Doctor по айди
                    4. Получить все Doctor по айди Hospital
                    5. Получить все Doctor по айди Department
                    6. Добавить новый Hospital
                    7. Найти Hospital по айди
                    8. Получить все Hospital
                    9. Получить всех Patient по айди Hospital
                    10. Удалить Hospital по айди
                    11. Получить все Hospital по address
                    12. Добавить Patient по айди Hospital
                    13. Получить Patient по айди
                    14. Получить Patient возраста
                    15. Переопределить Doctor в другой Department
                    16. Сортировка Patient по возрасту""");
            System.out.print("Выберите действие: ");
            int x = scanner.nextInt();
            scanner.nextLine();
            switch (x) {
                case 1 -> {
                    System.out.println("\u001B[31mВыбрано действие (1)\u001B[0m");
                    System.out.print("Напишите айди: ");
                    long findDepart = scanner.nextLong();
                    System.out.println(departmentService.getAllDepartmentByHospital(findDepart));
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("\u001B[31mВыбрано действие (2)\u001B[0m");
                    System.out.print("Введите имя: ");
                    String findDepartmentByName = scanner.nextLine();
                    System.out.println(departmentService.findDepartmentByName(findDepartmentByName));
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("\u001B[31mВыбрано действие (3)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long findDoctorId = scanner.nextLong();
                    System.out.println(doctorService.findDoctorById(findDoctorId));
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("\u001B[31mВыбрано действие (4)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long findDoctorByIdHospital = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(findDoctorByIdHospital));
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("\u001B[31mВыбрано действие (5)\u001B[0m");
                    System.out.print("Введите айди Department: ");
                    long findDoctorByIdDepartment = scanner.nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(findDoctorByIdDepartment));
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("\u001B[31mВыбрано действие (6)\u001B[0m");
                    System.out.print("Введите название Hospital: ");
                    String addHospitalName = scanner.next();
                    System.out.print("Введите address Hospital: ");
                    String addHospitalAddress = scanner.next();
                    Hospital newHospital = new Hospital(addHospitalName, addHospitalAddress, newDepartment, newDoctors, newPatient);
                    System.out.println(hospitalService.addHospital(newHospital));
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("\u001B[31mВыбрано действие (7)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long findHospitalById = scanner.nextLong();
                    System.out.println(hospitalService.findHospitalById(findHospitalById));
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("\u001B[31mВыбрано действие (8)\u001B[0m");
                    System.out.println(hospitalService.getAllHospital());
                    System.out.println();
                }
                case 9 -> {
                    System.out.println("\u001B[31mВыбрано действие (9)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long getAllPatientByIdHospital = scanner.nextLong();
                    System.out.println(hospitalService.getAllPatientFromHospital(getAllPatientByIdHospital));
                }
                case 10 -> {
                    System.out.println("\u001B[31mВыбрано действие (10)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long deleteHospitalById = scanner.nextLong();
                    System.out.println(hospitalService.deleteHospitalById(deleteHospitalById));
                }
                case 11 -> {
                    System.out.println("\u001B[31mВыбрано действие (11)\u001B[0m");
                    System.out.print("Введите address чтобы получить Hospital: ");
                    String findAddress = scanner.nextLine();
                    System.out.println(hospitalService.getAllHospitalByAddress(findAddress));
                }
                case 12 -> {
                    System.out.println("\u001B[31mВыбрано действие (12)\u001B[0m");
                    System.out.print("Введите айди Hospital: ");
                    long idHospital = scanner.nextLong();
                    System.out.print("Введите имя: ");
                    String newNamePatient = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String newNameLastName = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    int newNameAge = scanner.nextInt();
                    System.out.print("Введите пол (Male, Female): ");
                    String newGender = scanner.next().toUpperCase();
                    Gender gender = Gender.valueOf(newGender);
                    Patient newPatients2 = new Patient(newNamePatient, newNameLastName, newNameAge, gender);
                    List<Patient> newPatient2 = new ArrayList<>();
                    newPatient.add(newPatients2);
                    System.out.println(patientService.addPatientsToHospital(idHospital, newPatient2));
                    System.out.println();
                }
                case 13 -> {
                    System.out.println("\u001B[31mВыбрано действие (13)\u001B[0m");
                    System.out.print("Введите айди: ");
                    long findIdByPatient = scanner.nextLong();
                    System.out.println(patientService.getPatientById(findIdByPatient));
                    System.out.println();
                }
                case 14 -> {
                    System.out.println("\u001B[31mВыбрано действие (14)\u001B[0m");
                    System.out.println(patientService.getPatientByAge());
                    System.out.println();
                }
                case 15 -> {
                    System.out.println("\u001B[31mВыбрано действие (15)\u001B[0m");
                    System.out.print("Введите айди Department: ");
                    long findDepartment = scanner.nextLong();

                    List<Long> inputDoctorsId = new ArrayList<>();
                    System.out.print("Введите айди Doctor: ");
                    Long findDoctor = scanner.nextLong();
                    inputDoctorsId.add(findDoctor);


                    doctorService.assignDoctorToDepartment(findDepartment, inputDoctorsId);
                    System.out.println();
                }
                case 16 -> {
                    System.out.println("\u001B[31mВыбрано действие (16)\u001B[0m");
                    System.out.print("Введите asc или desc: ");
                    String as = scanner.next();

                    System.out.println(patientService.sortPatientsByAge(as));
                    break;
                }
            }
        }
    }
}