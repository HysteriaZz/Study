package dotcomgame;

import java.util.ArrayList;

/**
 * Created by KaiLin.Guo on 2017-08-10.
 */
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;
    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYourSelf(String stringGuess){
        String result = "miss";
        int index =  locationCells.indexOf(stringGuess);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :( ");
            }else {
                result = "hit";
            }

        }
        return result;
    }
}
