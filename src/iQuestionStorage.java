/** Created by Nav on 6/12/16. **/
public class iQuestionStorage {
    private int uniqueID;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char correctOption;
    private String messageOnAnswering;
    private boolean isDisplayed;

    public int getUniqueID() {
        return uniqueID;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getMessageOnAnswering() {
        return messageOnAnswering;
    }

    public char getCorrectOption() {
        return correctOption;
    }

    public boolean isDisplayed() {
        return isDisplayed;
    }

    public void setDisplayed(boolean displayed) {
        isDisplayed = displayed;
    }

    public iQuestionStorage(int uniqueID, String question, String optionA, String optionB, String optionC, String optionD, char correctOption, String messageOnAnswering, boolean isDisplayed) {
        this.uniqueID = uniqueID;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.messageOnAnswering = messageOnAnswering;
        this.isDisplayed = isDisplayed;
    }
}
