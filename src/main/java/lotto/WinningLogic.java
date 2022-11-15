package lotto;

import static lotto.Game.*;
import static lotto.option.IntegerOption.*;

public class WinningLogic {
    private static Integer match;
    private static Boolean bonus;
    private static double total = ZERO.option;
    public static void addScore(){
        lottos.stream().forEach(lotto -> {
            countMatch(lotto);
            checkBonus(lotto);
            countWinning();
        });
    }
    public static void calculateRate(){
        for(Winning winning: Winning.values()){
                    total += (double) winning.price * winning.count;
        }
        rate = total/Double.parseDouble(input) * 100;
    }
    private static void countWinning(){
        if(match.equals(FIRST_MATCH.option)) Winning.FIRST.count ++;
        if(bonus&match.equals(SECOND_MATCH.option)) Winning.SECOND.count ++;
        if(!bonus&match.equals(THIRD_MATCH.option)) Winning.THIRD.count ++;
        if(match.equals(FOURTH_MATCH.option)) Winning.FOURTH.count ++;
        if(match.equals(FIFTH_MATCH.option)) Winning.FIFTH.count ++;
    }
    private static void matchWinning(Winning winning){
        if(winning.match.equals(match)) winning.count++;
    }
    private static void countMatch(Lotto lotto){
        match = 0;
        lotto.getNumbers().stream().forEach(number-> addMatch(number));
    }
    private static void addMatch(Integer number){
        if(winningNumbers.getNumbers().contains(number)){
            match++;
        }
    }

    private static void checkBonus(Lotto lotto){
        bonus = false;
        if(lotto.getNumbers().contains(bonusNumber)){
            bonus = true;
        }
    }
}
