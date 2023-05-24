import java.util.List;

public class Validations {

    private static final List<String> availableLanguagesCodes = List.of("en", "pl");
    private static final Integer MIN_USER_LENGTH = 3;
    private static final Integer MAX_USER_LENGTH = 15;

    public static boolean checkUserLanguageCode(String userLanguageCode) {
        return availableLanguagesCodes.contains(userLanguageCode);
    }
    public static boolean checkUserNameLength(String userName) {
        return userName.length() >= MIN_USER_LENGTH && userName.length() <= MAX_USER_LENGTH;
    }
}
