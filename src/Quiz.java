import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Quiz {

    static Category rock = new Category("Rock", ""); //fill out descriptions later
    static Category chicken = new Category("Chicken", "");
    static Category totoro = new Category("Totoro", "");
    static Category cat = new Category("Cat", "");

    static Scanner sc = new Scanner(System.in);

    static Integer[] questionOrder = new Integer[]{1, 2, 3, 4, 5};
    static int currentQuestionNumber = 1;


    public static void main(String[] args) throws Exception {

        Introscreen();

        questionOrder = new Integer[]{1, 2, 3, 4, 5}; 
        Collections.shuffle(Arrays.asList(questionOrder));
        // for (int i = 0; i < questionOrder.length; i++) {
        //     System.out.println("Question order " + (i+1) + ": " + questionOrder[i]);
        // }

        
        
        Question.askQuestion(questionOrder[0]);

        sc.close();

    }


    public static void Introscreen(){

        System.out.println("\n\n\nWhich VS Pet are you?\n\n\n");

        System.out.println("Presented by David and Gavin\n");
        System.out.println("Answer the following questions to find out which VS Pet matches your personality!\n");
        System.out.println("Press Enter to begin the quiz!");

        sc.nextLine();

    }


    public static void calculateResult() {
        //calculate which category has the highest points and output result
        System.out.println("Calculating results..."); //placeholder

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


            // for (int i = 0; i < scores.length; i++) { 
            //     if (scores[i] > highestScore) {
            //         highestScore = scores[i];
            //         highestIndex = i;
            //     }
            // }

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
            System.out.println("Your VS pet is " + result.label + "!");
            System.out.println(result.description);
            System.out.println("Press Enter to restart the quiz!");
            sc.nextLine();
            Question.resetQuiz();
        } else {
            System.out.println("Error calculating result");
        }

    }
    

}