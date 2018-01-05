package dotcomgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by KaiLin.Guo on 2017-08-10.
 */
public class GameHelper {
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0){
                inputLine = null;
            }
        } catch (IOException e){
            System.out.println("IOException:" + e);
        }
        return inputLine;
    }

    public ArrayList<String> placeDotCom(){
        ArrayList<String> arrStr = new ArrayList<String>();

        int temp = (int) (Math.random() * 5) + 65;
        char y1 = (char) temp;
        char y2 = (char) (temp + 1);
        char y3 = (char) (temp + 2);

        int x = (int) (Math.random() * 7);
        arrStr.add(String.valueOf(y1) + String.valueOf(x));
        arrStr.add(String.valueOf(y2) + String.valueOf(x));
        arrStr.add(String.valueOf(y3) + String.valueOf(x));

        return arrStr;
    }
}
