package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {
    public HashMap<String,Integer> correctnumber;

    public String calCorrectNumber(List<Integer> lottonumber, List<Integer> lottoanswer,int bonusnumber) {
        String correctnumber;
        lottonumber.retainAll(lottoanswer);

        correctnumber = numToString(lottonumber.size());
        if(lottonumber.size() == 5 && lottonumber.contains(bonusnumber)) {
            correctnumber = "Bonus";
        }
        return correctnumber;
    }

    public String numToString(int number) {
        switch (number) {
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
        }
        return "Zero";
    }

}