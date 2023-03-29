package com.test.sc.assistants;

public class CreateEmail {

    public String createSubject(){
        return "Об оказании услуги";
    }

    public String createBody(String firstName, String lastName, String surName, String serviceName,
                             String date, int number){
        return "Уважаемый " + lastName + " " + firstName + " " + surName + ",\n" +
                "Услуга: " + serviceName + "\n" +
                "Номер: " + number + "\n" +
                "Дата: " + date + "\n" +
                "Успешно оказана!";
    }
}
