import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** Created by Nav on 6/12/16. **/
public class iQuestions {
    // Declared Variables
    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    private int points = 20;
    private int triesLeft = 3;
    private ArrayList<iQuestionStorage> iQuestions;
    private int totalCorrects = 0;

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

    public int getTotalCorrects() {
        return totalCorrects;
    }

    public void setTotalCorrects(int totalCorrects) {
        this.totalCorrects = totalCorrects;
    }

    // Check's the uniqueID if it doesn't exist, it adds the question else it doesn't
    private boolean addQuestion(String question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnAnswering, boolean isDisplayed){
        if(findQuestions(this.iQuestions.size() + 1) == null){
            this.iQuestions.add(new iQuestionStorage(this.iQuestions.size() + 1, question, optionA, optionB, optionC, optionD, correctOption, messageOnAnswering, isDisplayed));
            return true;
        }
        return false;
    }

    // Constructor for iQuestion Class
    public iQuestions(String playerName) {
        this.playerName = playerName;
        this.iQuestions = new ArrayList<iQuestionStorage>();
    }

    // Check's if uniqueID already exists
    private iQuestionStorage findQuestions(int uniqueID){
        for (iQuestionStorage checked: iQuestions){
            if(uniqueID == checked.getUniqueID()){
                return checked;
            }
        }
        return null;
    }

    // Add questions behind the scene
    public void addQuestions(){
        addQuestion("Test1", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test2", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test3", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test4", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test5", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test6", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test7", "1", "2", "3", "4", 'A', "Working", false);
        addQuestion("Test8", "1", "2", "3", "4", 'A', "Working", false);
    }

    // To check size of an array
    public void checkSize(){
        System.out.println(this.iQuestions.size());
    }

    // Display's Question (Public Method)
    public void displayQuestion(){
        iQuestions = shuffleQuestions(this.iQuestions);
        for (int i = 0; i < this.iQuestions.size(); i++){
            displayQuestion(i);
        }
        // prints total score at the end of game
        System.out.println("Player Name: " + this.playerName + " | " + "Points: " + this.points + " | " + " Tries Left: " + this.triesLeft);
        
        // Create any algorithm for score calculation
        int score = (getTriesLeft() * 3) + getPoints();
        System.out.println("Score: " + score);
    }

    // Display's Question (Private Method)
    private void displayQuestion(int number){
        iQuestionStorage storage = this.iQuestions.get(number);
        if (!storage.isDisplayed()){
            checkQuestion(storage.getQuestion(), storage.getOptionA(), storage.getOptionB(), storage.getOptionC(), storage.getOptionD(), storage.getCorrectOption(), storage.getMessageOnAnswering());
            storage.setDisplayed(true);
        }

    }

    // Check's if question is write or wrong... Acts accordingly
    private void checkQuestion(String question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnAnswering){
        char option;
        int deductionPoints = (int)(Math.random() * 5) + 1;
        System.out.println("Player Name: " + this.playerName + " | " + "Points: " + this.points + " | " + " Tries Left: " + this.triesLeft);
        System.out.println(question);
        System.out.println("A: " + optionA + "\n" + "B: " + optionB + "\n" + "C: " + optionC + "\n" + "D: " + optionD);
        do {
            System.out.print("Enter your answer: ");
            option = this.scanner.next().toUpperCase().charAt(0); // takes input from user and converts it to uppercase.
            if(option == correctOption){
                setPoints(getPoints() + 2);
                setTotalCorrects(getTotalCorrects() + 1);
                if(getTotalCorrects() == 5){
                    setTriesLeft(getTriesLeft() + 1);
                }
                continue;
            }else{
                if (triesLeft > 0 && points >= deductionPoints){
                    System.out.println("Wrong answer, please try again...");
                    setPoints(getPoints() - deductionPoints);
                    setTriesLeft(getTriesLeft() - 1);
                }else{
                    if(getPoints() < deductionPoints || getTriesLeft() < 0){
                        System.out.println("You cannot continue as you are out of points or tries");
                    }else{
                        System.out.println("You cannot continue as you are out of points or tries");
                    }
                    System.exit(0);
                }
            }
        }while(option != correctOption);
        System.out.println(messageOnAnswering);
    }

    // Shuffles the arraylist
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