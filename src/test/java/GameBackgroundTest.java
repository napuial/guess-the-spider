import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameBackgroundTest {

    @Test
    void tablesTest() {
        String testSpiderName = "philaeus chrysops";
        GameBackground gameBackground = new GameBackground(testSpiderName);
        Assertions.assertEquals(17, gameBackground.getAnswerTable().size());
        Assertions.assertEquals(12, gameBackground.getUniqueLettersInAnswer().size());
    }
}
