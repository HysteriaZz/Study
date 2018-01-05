package dotcomgame;

import java.util.ArrayList;

/**
 * Created by KaiLin.Guo on 2017-08-10.
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotcComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotcComsList.add(one);
        dotcComsList.add(two);
        dotcComsList.add(three);
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
        for (DotCom dotComToSet : dotcComsList){
            ArrayList<String> newlocation = helper.placeDotCom();
            dotComToSet.setLocationCells(newlocation);
            System.out.println(newlocation);
        }
    }

    public void startPlaying(){
        System.out.println("Dot Com Game is starting...");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("InterruptedException:" + e);
        }

        setUpGame();
        while (!dotcComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest : dotcComsList){
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.equals("hit")){
                break;
            }
            if (result.equals("kill")){
                dotcComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    public void finishGame(){
        System.out.println("All Dot Coms are dead! Your stock is now worthless");
        if (numOfGuesses <= 18){
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        }else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }
}
