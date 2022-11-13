package controller;

import domain.MatchingNumber;
import util.ResultView;
import util.WinNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputController {
    public HashMap<String,Integer> matchingNumber(List<List<Integer>> lottolist,List<Integer> lottoanswer,int bonusnumber) {
        HashMap<String,Integer> correctnumber = new HashMap<>();
        initHashmap(correctnumber);

        for(int i=0; i<lottolist.size(); i++) {
            String matchingnumber;
            matchingnumber = calMatchingNumber(lottolist.get(i),lottoanswer,bonusnumber);
            int eachnum = correctnumber.get(matchingnumber);
            correctnumber.put(matchingnumber,eachnum+1);
        }
        return correctnumber;
    }

    public void initHashmap(HashMap<String,Integer> correctnumber) {
        WinNum[] values = WinNum.values();
        for(int i=0; i< values.length; i++) {
            correctnumber.put(values[i].toString(),0);
        }
    }

    public String calMatchingNumber(List<Integer> lottonumber, List<Integer> lottoanswer,int bonusnumber) {
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

    public int winningAmount(MatchingNumber matchingNumber) {
        int price = 0;
        WinNum[] values = WinNum.values();
        HashMap<String,Integer> matchingnumbers = matchingNumber.getMatchingNumber();

        for(int i=0; i< values.length; i++) {
            String money = WinNum.valueOf(values[i].toString()).label();
            int winnumber = matchingnumbers.get(values[i].toString());
            price += Integer.parseInt(money) * winnumber;
        }
        return price;
    }
}