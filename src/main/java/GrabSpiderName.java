import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GrabSpiderName {

    private final File file = new File("src/main/resources/names.txt");
    private final int MAX_AMOUNT_OF_SPIDERS_NAMES = 10;
    private final List<String> spidersNames = new ArrayList<>();

    private String spiderName;

    {
        spiderName = chooseRandomSpiderName();
    }

    private String chooseRandomSpiderName() {
        collectAllSpidersFromFile();
        Random random = new Random();
        int randomSpiderNameIndex = random.nextInt(spidersNames.size());
        return spidersNames.get(randomSpiderNameIndex);
    }

    void collectAllSpidersFromFile() {
        int uploadedSpidersNames = 0;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine() && uploadedSpidersNames < MAX_AMOUNT_OF_SPIDERS_NAMES) {
                spidersNames.add(scanner.nextLine());
                uploadedSpidersNames++;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getSpiderName() {
        return spiderName;
    }
}
