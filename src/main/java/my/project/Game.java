package my.project;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Game {

    private UserSettings userSettings;
    private ResourceBundle resourceBundle;

    public void askForLanguage() {
        Locale localeForEnglish = new Locale("en");
        Locale localeForPolish = new Locale("pl");
        ResourceBundle resourceBundleEnglish = ResourceBundle.getBundle("MessagesBundle", localeForEnglish);
        ResourceBundle resourceBundlePolish = ResourceBundle.getBundle("MessagesBundle", localeForPolish);
        System.out.println(
                new StringBuilder(resourceBundleEnglish.getString("chooseYourLanguage"))
                        .append(" / ")
                        .append(resourceBundlePolish.getString("chooseYourLanguage"))
                        .append("\n\n")
                        .append(resourceBundleEnglish.getString("setLanguageCode"))
                        .append("\n")
                        .append(resourceBundlePolish.getString("setLanguageCode"))
                        .append("\n")
        );
        Scanner languageCode = new Scanner(System.in);
        userSettings = new UserSettings(new Locale(languageCode.next()));
        languageCode.close();
        resourceBundle = ResourceBundle.getBundle("MessagesBundle", userSettings.getUSER_LOCALE());
        System.out.println(resourceBundle.getString("userLanguage"));
    }
}
