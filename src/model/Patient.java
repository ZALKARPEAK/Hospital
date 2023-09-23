package model;

import gender.Gender;

public class Patient {
    private static int idd4 = 1;
    private final int id4;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Gender gender;

    public Patient(String firstName, String lastName, int age, Gender gender) {
        this.id4 = idd4++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }


    public int getId4() {
        return id4;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id4 +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
