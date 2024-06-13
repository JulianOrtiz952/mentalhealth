package com.health.mentalhealth.domain.service;

import com.health.mentalhealth.application.exception.EmptyException;

public class YearMonthDay {

    public boolean validation(int year, int month, int day){
        if(day == 0 || month == 0) throw new EmptyException("day or month");
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
        }
        int daysInMonth = getDaysInMonth(month, year);
        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("El día " + day + " no es válido para el mes " + month);
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        // Un año es bisiesto si es divisible por 4
        // Excepto si es divisible por 100, a menos que también sea divisible por 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

}
