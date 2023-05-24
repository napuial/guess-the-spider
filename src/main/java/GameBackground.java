import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class GameBackground {

    private final ArrayList<Character> answerTable = new ArrayList<>();
    private final ArrayList<Character> gameTable = new ArrayList<>();

    private Set<Character> uniqueLettersInAnswer;

    public GameBackground(String title) {
        prepareAnswerTable(title);
        prepareGameTable();
        generateUniqueLettersInAnswer();
    }

    private void generateUniqueLettersInAnswer() {
        uniqueLettersInAnswer = answerTable.stream().collect(Collectors.toSet());
        uniqueLettersInAnswer.remove(' ');
    }

    private void prepareGameTable() {
        for (Character c : answerTable) {
            if (c == ' ') {
                gameTable.add(c);
            } else {
                gameTable.add('_');
            }
        }
    }

    private void prepareAnswerTable(String spider) {
        for (int i = 0; i < spider.length(); i++) {
            answerTable.add(spider.charAt(i));
        }
    }

    public void showTable(ArrayList<Character> table) {
        System.out.println();
        for (Character c : table) {
            System.out.print(c);
        }
        System.out.println();
    }

    public ArrayList<Character> getAnswerTable() {
        return answerTable;
    }

    public ArrayList<Character> getGameTable() {
        return gameTable;
    }

    public Set<Character> getUniqueLettersInAnswer() {
        return uniqueLettersInAnswer;
    }
}
