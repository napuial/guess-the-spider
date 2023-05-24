import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserSettings {

     private Locale userLocale;
     private ResourceBundle resourceBundle;
     private String userName;

    {
        takeUserLanguageCodeAndSetLocale();
        setResourceBundle();
        takeAndSetUserName();
    }

    private void takeUserLanguageCodeAndSetLocale() {
        Locale localeForEnglish = new Locale("en");
        Locale localeForPolish = new Locale("pl");
        ResourceBundle resourceBundleEnglish = ResourceBundle.getBundle("MessagesBundle", localeForEnglish);
        ResourceBundle resourceBundlePolish = ResourceBundle.getBundle("MessagesBundle", localeForPolish);
        System.out.printf("%s\n%s\n",
                resourceBundleEnglish.getString("setLanguageCode"),
                resourceBundlePolish.getString("setLanguageCode"));
        Scanner scanner = new Scanner(System.in);
        String languageCode = scanner.next().toLowerCase();
        if(!Validations.checkUserLanguageCode(languageCode)) {
            takeUserLanguageCodeAndSetLocale();
        } else {
            this.userLocale = new Locale(languageCode);
        }
    }

    private void takeAndSetUserName() {
        System.out.println("\n" + resourceBundle.getString("setUserName"));
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        if(!Validations.checkUserNameLength(userName)) {
            System.out.println(resourceBundle.getString("validationNameFailed"));
            takeAndSetUserName();
        } else {
            this.userName = userName;
        }
    }

    private void setResourceBundle() {
        this.resourceBundle = ResourceBundle.getBundle("MessagesBundle", userLocale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String getUserName() {
        return userName;
    }
}
