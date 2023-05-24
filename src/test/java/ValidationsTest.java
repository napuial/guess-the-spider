import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationsTest {

    @Test
    void checkUserLanguageCodeTest() {
        Assertions.assertTrue(Validations.checkUserLanguageCode("en"));
        Assertions.assertTrue(Validations.checkUserLanguageCode("pl"));
        Assertions.assertFalse(Validations.checkUserLanguageCode("unexpected language code"));
    }

    @Test
    void checkUserNameLengthTest() {
        String userNameToShort = "n";
        String userNameMinLength = "usr";
        String userNameMidLength = "user name";
        String userNameMaxLength = "valid user name";
        String userNameToLong = "to long user name";
        Assertions.assertFalse(Validations.checkUserNameLength(userNameToShort));
        Assertions.assertTrue(Validations.checkUserNameLength(userNameMinLength));
        Assertions.assertTrue(Validations.checkUserNameLength(userNameMidLength));
        Assertions.assertTrue(Validations.checkUserNameLength(userNameMaxLength));
        Assertions.assertFalse(Validations.checkUserNameLength(userNameToLong));
    }
}
