package my.project;

import java.util.Locale;

public class UserSettings {

    private final Locale USER_LOCALE;

    public UserSettings(Locale locale) {
        USER_LOCALE = locale;
    }

    Locale getUSER_LOCALE() {
        return USER_LOCALE;
    }
}
