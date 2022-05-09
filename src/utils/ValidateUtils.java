package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String PASSWORD_REGEX = "^([a-zA-Z0-9]{8,})";
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;

    public static final String NUMBER_1_5_REGEX = "^[1-5]\\d*$";

    public static final String NUMBER_REGEX = "\\d+";

    public static boolean isNumberValid(String number) {
        return Pattern.compile(NUMBER_REGEX).matcher(number).matches();
    }
    public static boolean isNumberFrom1To5Valid(String number) {
        return Pattern.compile(NUMBER_1_5_REGEX).matcher(number).matches();
    }


    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isFullNameValid(String fullName) {
        return Pattern.compile(NAME_REGEX).matcher(fullName).matches();
    }

    public static boolean isPhoneValid(String number) {
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean isDateValid(String dateStr){
        try {
            LocalDate.parse(toISODate(dateStr),dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    public static String toISODate(String dateStr){
        String[] iSODateArray = dateStr.split("-");
//        String iSODate = iSODateArray[2]+ iSODateArray[1] + iSODateArray[0];
//        return iSODate;
        String iSODate = "";
        for (int i = iSODateArray.length - 1; i >= 0; i--) {
            iSODate += iSODateArray[i];
        }
        return iSODate;
        }

    public static String toTodayISO(String dateStr){
        String[] todayISOArray = LocalDate.now().toString().split("-");
        String todayISO ="";
        for(int i = 0; i<=todayISOArray.length -1; i++){
            todayISO +=todayISOArray[i];
        }
        return todayISO;
    }

    public static long calculateDays(String strDate){
        LocalDate now = LocalDate.now();
        String[] str = strDate.split("-");
        LocalDate myDate = LocalDate.of(Integer.parseInt(str[2]),Integer.parseInt(str[1]),Integer.parseInt(str[0]));
        long dif = ChronoUnit.DAYS.between(now,myDate );
        return dif;
    }
}



