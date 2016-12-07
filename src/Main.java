import java.util.ArrayList;
import java.util.Scanner;

/** Created by navjot on 6/12/16. **/
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    public static void main(String[] args) {

        System.out.println("|=============== WELCOME TO iQUIZ ===============|");
        System.out.print("Are you ready to begin? Y / N ");
        char option = scanner.next().charAt(0);
        if(option == 'Y' || option == 'y'){
            System.out.print("Enter your name: ");
            name = scanner.next();
            if(name != null){
                iQuestions iQuestions = new iQuestions(name);
                iQuestions.addQuestions();
                iQuestions.checkSize();
                iQuestions.displayQuestion();
            }
        }else{
            System.out.println("See you soon...");
        }

    }

}
