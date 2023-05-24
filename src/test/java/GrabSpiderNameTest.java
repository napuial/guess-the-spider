import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrabSpiderNameTest {

    @Test
    void spiderNameTest() {
        GrabSpiderName grabSpiderName = new GrabSpiderName();
        //spider name should be not null
        Assertions.assertTrue(grabSpiderName.getSpiderName() != null);
        //spider name should have a rational length
        Assertions.assertTrue(grabSpiderName.getSpiderName().length() > 0);
        Assertions.assertTrue(grabSpiderName.getSpiderName().length() < 50);
    }
}
