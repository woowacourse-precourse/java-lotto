package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Saturday {
    private List<Integer> winNumbers;
    private int winBonus;
    private List<Integer> statistics;

    Saturday(String input_win,String input_bonus)throws IllegalArgumentException{
        validateStrInput(input_win,input_bonus);
        String[] numbers = input_win.split(",");
        List<Integer> win = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            win.add(Integer.parseInt(numbers[i]));
        }
        int bonus = Integer.parseInt(input_bonus);
        win.sort(Comparator.naturalOrder());
        validateIntInput(win,bonus);

        statistics = new ArrayList<>(List.of(0,0,0,0,0));
    }


    public void validateStrInput(String win,String bonus)throws IllegalArgumentException{
        if(!isWinRegex(win)) throw new IllegalArgumentException();
        if(!isBonusRegex(bonus)) throw new IllegalArgumentException();
    }
    public void validateIntInput(List<Integer> win,int bonus) throws IllegalArgumentException{
        if(isOut(win,bonus)) throw new IllegalArgumentException();
        if(isAlready(win,bonus)) throw new IllegalArgumentException();
    }
    public boolean isWinRegex(String win){
        if(win.matches(Numbers.Win.regex)) return true;
        return false;
    }
    public boolean isBonusRegex(String bonus){
        if(bonus.matches(Numbers.Bonus.regex)) return true;
        return false;
    }
    public boolean isOut(List<Integer> win,int bonus){
        for(int i=0; i<6; i++){
            if(win.get(i)>45)return true;
        }
        if(bonus>45) return true;
        return false;
    }
    public boolean isAlready(List<Integer> win,int bonus){
        return win.contains(bonus);
    }
}
