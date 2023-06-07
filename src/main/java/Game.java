import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final UserSettings userSettings = new UserSettings();
    private final GrabSpiderName grabSpider = new GrabSpiderName();
    private final GameBackground gameBackground = new GameBackground(grabSpider.getSpiderName());
    private final ArrayList<Character> mistakesLog = new ArrayList<>();
    private final Integer MAX_AMOUNT_OF_MISTAKES = 5;
    private Integer mistakes = 0;

    public boolean play() {
        System.out.printf("\n%s%s%s\n%s\n",
                userSettings.getResourceBundle().getString("startPart1"),
                userSettings.getUserName(),
                userSettings.getResourceBundle().getString("startPart2"),
                "\u001B[32m/\\\\O.O//\\\u001B[0m");

        while(mistakes < MAX_AMOUNT_OF_MISTAKES && gameBackground.getUniqueLettersInAnswer().size() > 0) {
            gameBackground.showTable(gameBackground.getGameTable());
            char userChoice = takeCharacterFromUser();
            if(gameBackground.getAnswerTable().contains(userChoice)) {
                gameBackground.getUniqueLettersInAnswer().remove(userChoice);
                putCharacterOnGameTable(userChoice);
            } else {
                checkIfTrueMistake(userChoice);
                System.out.printf("\u001B[32m%s%d %s\u001B[0m\n",
                        userSettings.getResourceBundle().getString("mistakes"),
                        mistakes, mistakesLog);
            }
        }
        chooseEnd();
        return false;
    }

    private void chooseEnd() {
        if(gameBackground.getUniqueLettersInAnswer().size() == 0) {
            System.out.printf("\n\u001B[32m%s\u001B[0m\n%s%s%s",
                    grabSpider.getSpiderName(),
                    userSettings.getResourceBundle().getString("winPart1"),
                    userSettings.getUserName(),
                    userSettings.getResourceBundle().getString("winPart2"));
        } else {
            System.out.printf("\n%s%s%s\n\u001B[32m%s\u001B[0m",
                    userSettings.getResourceBundle().getString("losePart1"),
                    userSettings.getUserName(),
                    userSettings.getResourceBundle().getString("losePart2"),
                    grabSpider.getSpiderName());
        }
    }

    private void checkIfTrueMistake(Character useChoice) {
        if(!mistakesLog.contains(useChoice) && !gameBackground.getGameTable().contains(useChoice)) {
            mistakesLog.add(useChoice);
            mistakes++;
        }
    }

    private void putCharacterOnGameTable(Character character) {
        int index;
        for (Character c : gameBackground.getAnswerTable()) {
            if(c == character) {
                index = gameBackground.getAnswerTable().indexOf(c);
                gameBackground.getAnswerTable().set(index, ' ');
                gameBackground.getGameTable().set(index, c);
            }
        }
    }

    private Character takeCharacterFromUser() {
        System.out.print(userSettings.getResourceBundle().getString("enterCharacter"));
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }
}
