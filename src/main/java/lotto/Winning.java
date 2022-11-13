package lotto;

import lotto.UI.ERRORUI;
import lotto.config.BaseException;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private List<Integer> winnings;

    private Integer bonus;

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

    public void setBonus(String s){
        Integer check = checkBonusNum(s);
        try {
            if(checkBonusRange(check)){
                bonus = check;
            }
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorRange();
        }
    }

    private Integer checkBonusNum(String s){
        Integer bonus = null;
        try {
            bonus = Integer.parseInt(s);
        }catch (IllegalArgumentException e){
            ERRORUI.getErrorInputNum();
        }
        return bonus;
    }

    private boolean checkBonusRange(Integer bonus){
        if(bonus <1 || bonus >45){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public Integer getBonus(){
        return bonus;
    }
}
