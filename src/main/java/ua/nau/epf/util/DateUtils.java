package ua.nau.epf.util;

import static java.time.LocalDate.now;

public class DateUtils {
    private static final int FIRST_SEMESTER_START_MONTH = 9;
    private static final int FIRST_SEMESTER_END_MONTH = 2;

    public static int calculateCurrentSemester(int course) {
        if (isItFirstSemesterOfYearNow()) {
            return ((course * 2) - 1);
        } else {
            return (course * 2);
        }
    }

    public static boolean isItFirstSemesterOfYearNow() {
        int currentMonth = getCurrentMoth();
        return currentMonth >= FIRST_SEMESTER_START_MONTH || currentMonth < FIRST_SEMESTER_END_MONTH;
    }

    public static int getCourseBySemester(int semester) {
        return semester % 2 == 0 ? semester / 2 : (semester / 2) + 1;
    }

    public static String getCurrentEducationalYear() {
        int currentYear = now().getYear();
        int currentMonth = getCurrentMoth();
        if (currentMonth < FIRST_SEMESTER_START_MONTH) {
            return (currentYear - 1) + "-" + currentYear;
        } else {
            return currentYear + "-" + (currentYear + 1);
        }
    }

    private static int getCurrentMoth() {
        return now().getMonthValue();
    }
}
