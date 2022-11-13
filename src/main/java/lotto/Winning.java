package lotto;

import lotto.UI.ERRORUI;
import lotto.config.BaseException;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private List<Integer> winnings;

    public void setWinnings(String input) {
        List<Integer> check = new ArrayList<>();
        String[] str = input.split(",");
        check = checkNum(str);
        try {
            if(checkRange(check)){
                winnings = check;
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorRange();
        }
    }

    private List<Integer> checkNum(String[] input){
        List<Integer> num = new ArrayList<>();
        try {
            for (String s : input) {
                num.add(Integer.parseInt(s));
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
        }
        return num;
    }

    private boolean checkRange(List<Integer> check){
        for(Integer integer : check){
            if(integer<1 || integer>45){
                throw  new IllegalArgumentException();
            }
        }
        return true;
    }

    public List<Integer> getWinnings(){
        return winnings;
    }

}
