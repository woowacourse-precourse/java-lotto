package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {
    public HashMap<Integer,Integer> correctnumber;

    public int calCorrectNumber(List<Integer> lottonumber, List<Integer> lottoanswer,int bonusnumber) {
        int correctnumber;
        lottonumber.retainAll(lottoanswer);

        if(lottonumber.size() == 5 && lottonumber.contains(bonusnumber)) {
            correctnumber = 7;
        }
        correctnumber = lottonumber.size();
        return correctnumber;
    }


}