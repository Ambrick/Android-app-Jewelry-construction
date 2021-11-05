package com.example.jewelryConstructionProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RandomDateGenerator {

    public static String generateDate(){
        SimpleDateFormat dfDateTime  = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        int year = randBetween(1900, 2021);
        int month = randBetween(0, 11);

        GregorianCalendar gCalendar = new GregorianCalendar(year, month, 1);
        int day = randBetween(1, gCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        gCalendar.set(year, month, day);
        return dfDateTime.format(gCalendar.getTime());
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
