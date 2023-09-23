package model;

import gender.Gender;

public class Doctor {
    private static int idd1 = 1;
    private final int id1;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final int experienceYear;

    public Doctor(String firstName, String lastName, Gender gender, int experienceYear) {
        this.id1 = idd1++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
    }

    public int getId1() {
        return id1;
    }


    @Override
    public String toString() {
        return "\nDoctor - " +
                "id: " + id1 + "\n" +
                "firstName: " + firstName + '\'' +
                ", lastName: " + lastName + '\'' +
                ", gender: " + gender +
                ", experienceYear: " + experienceYear;
    }
}
