package simpledotcomgame;

import java.util.ArrayList;

/**
 * Created by KaiLin.Guo on 2017-08-10.
 */
public class SimpleDotCom {
    ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    public String checkYourSelf(String stringGuess){
        String result = "miss";
        int index =  locationCells.indexOf(stringGuess);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
            }else {
                result = "hit";
            }

        }
        System.out.println(result);
        return result;
    }
}
