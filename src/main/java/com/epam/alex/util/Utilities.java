package com.epam.alex.util;

import com.epam.alex.exceptions.UtilException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 1/22/2016.
 *
 * @author Bocharnikov Alexander
 */
public final class Utilities {

    public static final String MM_DD_YYYY_REGEX = "^(([0]\\d)|(1[0-2]))/(([0-2][0-9])|(3[0-1]))/[0-2]\\d{3}$";
    public static final String YYYY_MM_DD_REGEX = "^[0-2]\\d{3}/(([0-2][0-9])|(3[0-1]))/(([0]\\d)|(1[0-2]))$";
    private static final Logger log = Logger.getLogger(Utilities.class);
    public static final String YYYY_MM_DD = "yyyy/MM/dd";
    public static final String MM_DD_YYYY = "MM/dd/yyyy";


    public static Calendar getCalendarFromString(String date, String stringFormat) {
        if (!validateDate(date, stringFormat)) {
            log.error("Wrong date format");
            throw new UtilException("Wrong date format");
        }
        Calendar result = Calendar.getInstance();
        try {
            SimpleDateFormat format = new SimpleDateFormat(stringFormat);
            Date parse = format.parse(date);
            result.setTime(parse);
        } catch (ParseException e) {
            log.error("Can't parse date");
            throw new UtilException(e);
        }
        return result;
    }

    private static boolean validateDate(String date, String format) {
        switch (format) {
            case YYYY_MM_DD:
                return date.matches(YYYY_MM_DD_REGEX);
            case MM_DD_YYYY:
                return date.matches(MM_DD_YYYY_REGEX);
            default:
                return false;

        }

    }

}
