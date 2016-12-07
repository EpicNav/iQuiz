import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nav on 6/12/16.
 **/
public class iQuestions {
    // Declared Variables
    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    private int points = 20;
    private int triesLeft = 3;
    private ArrayList<iQuestionStorage> iQuestions;

    // Getters and Setters

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public void setTriesLeft(int triesLeft) {
        this.triesLeft = triesLeft;
    }

    // Adds new question to array list
    private boolean addQuestion(String question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnAnswering, boolean isDisplayed) {
        if (findQuestions(this.iQuestions.size() + 1) == null) {
            this.iQuestions.add(new iQuestionStorage(this.iQuestions.size() + 1, question, optionA, optionB, optionC, optionD, correctOption, messageOnAnswering, isDisplayed));
            return true;
        }
        return false;
    }

    // Constructor
    public iQuestions(String playerName) {
        this.playerName = playerName;
        this.iQuestions = new ArrayList<iQuestionStorage>();
    }

    private iQuestionStorage findQuestions(int uniqueID) {
        for (iQuestionStorage checked : iQuestions) {
            if (uniqueID == checked.getUniqueID()) {
                return checked;
            }
        }
        return null;
    }

    public void addQuestions() {
        addQuestion("Test1", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test2", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test3", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test4", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test5", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test6", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test7", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test8", "1", "2", "3", "4", 'A', "Working", false);
    }

    public void checkSize() {
        System.out.println(this.iQuestions.size());
    }

    public void displayQuestion() {
        iQuestions = shuffleQuestions(iQuestions);
        for (int i = 0; i < this.iQuestions.size(); i++) {
            displayQuestion(i);
        }
    }

    private void displayQuestion(int number) {
        iQuestionStorage questionToDisplay = this.iQuestions.get(number);
        if (!questionToDisplay.isDisplayed()) {
            checkQuestion(questionToDisplay.getQuestion(), questionToDisplay.getOptionA(), questionToDisplay.getOptionB(), questionToDisplay.getOptionC(), questionToDisplay.getOptionD(), questionToDisplay.getCorrectOption(), questionToDisplay.getMessageOnAnswering(), questionToDisplay.isDisplayed());
            questionToDisplay.setDisplayed(true);
        }
    }

    private int randomNumberGenerator() {
        Random rand = new Random();
        int randomNumber = rand.nextInt((iQuestions.size() - 1) + 1);
        return randomNumber;
    }

    private void checkQuestion(String question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnAnswering, boolean isDisplayed) {
        char option;
        System.out.println("Player Name: " + this.playerName + " | " + "Points: " + this.points + " | " + " Tries Left: " + this.triesLeft);
        System.out.println(question);
        System.out.println("A: " + optionA + "\n" + "B: " + optionB + "\n" + "C: " + optionC + "\n" + "D: " + optionD);
        do {
            option = this.scanner.next().toUpperCase().charAt(0);
            if (option == correctOption) {
                continue;
            } else {
                if (triesLeft > 0 && points > 0) {
                    setPoints(getPoints() - 5);
                    setTriesLeft(getTriesLeft() - 1);
                } else {
                    if (getPoints() < 0 || getTriesLeft() < 0) {
                        System.out.println("You cannot continue as you are out of points or tries");
                    } else {
                        System.out.println("You cannot continue as you are out of points or tries");
                    }
                }
            }
        } while (option != correctOption);
        System.out.println(messageOnAnswering);
    }

    private ArrayList<iQuestionStorage> shuffleQuestions(ArrayList<iQuestionStorage> questionDatabase) {
        if (questionDatabase == null) {
            return questionDatabase;
        }

        if (questionDatabase.isEmpty()) {
            return questionDatabase;
        }

        int n = questionDatabase.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            iQuestionStorage helper = questionDatabase.get(i);
            questionDatabase.set(i, questionDatabase.get(change));
            questionDatabase.set(change, helper);
        }
        return questionDatabase;
    }
}
