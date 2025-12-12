import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Quiz {

static String name;
 static Category rock = new Category(
    "Rock",
    "You're calm, steady, and reliable and unshakeable like a mountain!",
    """
       _______
    /         \\
   |           |
   |. (•_•)   |
    \\_______/
    """
);

static Category chicken = new Category(
    "Chicken",
    "You're kinda mindless, a little clucky, but full of energy and enthusiasm!",
    """
         __
       <(o )
        ( ._> /
         `---'
    """
);

static Category totoro = new Category(
    "Totoro",
    "You're gentle, imaginative, and comforting to be around with a wholesome, magical aura!",
    """
        ／￣￣＼
       (  ´･ω･)
       ()    ) づ
        しーJ
    """
);

static Category cat = new Category(
    "Cat",
    "You are independent, elegant, full of energy, observant and clever!",
    """
     /\\_/\\
    ( o.o )
     > ^ <
     |. .|
    """
);



    static Scanner sc = new Scanner(System.in);


    static Integer[] questionOrder;
    static int currentQuestionNumber = 1;


    public static void main(String[] args) throws Exception {

        Introscreen();

        int totalQuestions = Question.getTotalQuestions();
        questionOrder = new Integer[totalQuestions];

        for (int i = 0; i < totalQuestions; i++) {
            questionOrder[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(questionOrder));
        Question.askQuestion(questionOrder[0]);

        sc.close();

    }


    public static void Introscreen(){

        System.out.println("\n\n\nWhich VS Pet are you?\n\n\n");

        System.out.println("Presented by David and Gavin\n");
        System.out.println("Answer the following questions to find out which VS Pet matches your personality!\n");
        System.out.print("What is your name?  ");
        System.out.println("Enter your name:");
        name = sc.nextLine();

            System.out.println("\nWelcome, " + name + "! Please hit Enter to start the quiz!");

        sc.nextLine();

    }


    public static void calculateResult() throws InterruptedException {
        //calculate which category has the highest points and output result
         System.out.print("Calculating");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(450);
                System.out.print(".");
                }
        } catch 
        (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n");

         int[] scores = Question.WhichOneAreYou;
         int highestScore = -1;
         int highestIndex = 0;

         List<Integer> tied = new ArrayList<>(); 



         for (int score : scores){

            if (score > highestScore){
                highestScore = score;
            }

            for (int i = 0; i < scores.length; i++){
                if(scores[i] == highestScore){
                    tied.add(i);
                }
            }

            Collections.shuffle(tied); 
            highestIndex = tied.get(0); 

            System.out.println(tied);

         }

        Category result = null; 

        switch (highestIndex){
            case 0:
                result = rock;
                break;
            case 1:
                result = chicken;
                break;
            case 2:
                result = totoro;
                break;
            case 3:
                result = cat;
                break;
            
        }

        if (result != null) {
            System.out.println("Thanks for completing the quiz, " + name + "! Your VS pet is: " + result.label + "!\n");
            System.out.println(result.asciiArt);
            System.out.println(result.description + "\n");
            System.out.println("Press Enter to restart the quiz!");
            sc.nextLine();
            Question.resetQuiz();
        } else {
            System.out.println("Error calculating result");
        }

    }
    

}
