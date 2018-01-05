package simpledotcomgame;

import java.util.ArrayList;

/**
 * Created by KaiLin.Guo on 2017-08-10.
 */
public class SimpleDotComGame {
    public void startGame(){
        System.out.println("Simple Dot Com Game is starting...");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println("InterruptedException:" + e);
        }

        int numOfGuesses = 0;
        SimpleGameHelper helper = new SimpleGameHelper();

        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        ArrayList<String>  locations= new ArrayList<String>();
        locations.add(Integer.toString(randomNum));
        locations.add(Integer.toString(randomNum + 1));
        locations.add(Integer.toString(randomNum + 2));

        theDotCom.setLocationCells(locations);
        boolean isActive = true;

        while (isActive){
            String guess = helper.getUserInput("enter a num");
            String result = theDotCom.checkYourSelf(guess);
            numOfGuesses++;
            if (result.equals("kill")){
                isActive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }

    }
}
