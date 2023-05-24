import java.util.Scanner;

public class Game {

    private final UserSettings userSettings = new UserSettings();
    private final GrabSpiderName grabSpider = new GrabSpiderName();
    private final GameBackground gameBackground = new GameBackground(grabSpider.getSpiderName());
    private final Integer MAX_AMOUNT_OF_MISTAKES = 5;
    private Integer mistakes = 0;

    public boolean play() {
        System.out.printf("\n%s%s%s\n",
                userSettings.getResourceBundle().getString("startPart1"),
                userSettings.getUserName(),
                userSettings.getResourceBundle().getString("startPart2"));
        while(mistakes < MAX_AMOUNT_OF_MISTAKES && gameBackground.getUniqueLettersInAnswer().size() > 0) {
            gameBackground.showTable(gameBackground.getGameTable());
            char userChoice = takeCharacterFromUser();
            if(gameBackground.getAnswerTable().contains(userChoice)) {
                gameBackground.getUniqueLettersInAnswer().remove(userChoice);
                putCharacterOnGameTable(userChoice);
            } else {
                mistakes++;
                System.out.printf("%s%d\n",
                        userSettings.getResourceBundle().getString("mistakes"),
                        mistakes);
            }
        }
        chooseEnd();
        return false;
    }

    private void chooseEnd() {
        if(gameBackground.getUniqueLettersInAnswer().size() == 0) {
            System.out.printf("\n%s%s%s",
                    userSettings.getResourceBundle().getString("winPart1"),
                    userSettings.getUserName(),
                    userSettings.getResourceBundle().getString("winPart2"));
        } else {
            System.out.printf("\n%s%s%s\n%s",
                    userSettings.getResourceBundle().getString("losePart1"),
                    userSettings.getUserName(),
                    userSettings.getResourceBundle().getString("losePart2"),
                    grabSpider.getSpiderName());
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
