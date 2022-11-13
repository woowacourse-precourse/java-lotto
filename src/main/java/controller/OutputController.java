package controller;

import util.WinNum;

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
            correctnumber = WinNum.Bonus.toString();
        }
        return correctnumber;
    }

    public String numToString(int number) {
        switch (number) {
            case 3: return WinNum.Three.toString();
            case 4: return WinNum.Four.toString();
            case 5: return WinNum.Five.toString();
            case 6: return WinNum.Six.toString();
        }
        return WinNum.Nothing.toString();
    }

}