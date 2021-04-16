package ua.nau.epf.util;

public class Validator {
    public static final String USERNAME_REGEX = "^[a-z0-9_-]{3,15}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,32}$";
    public static final String NAME_REGEX = "^[A-Z][a-z]{2,20}$";
    public static final String EMAIL_REGEX = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
    public static final String PHONE_NUMBER_REGEX = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
    private Validator() {
    }
}
