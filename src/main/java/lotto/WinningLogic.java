package lotto;

import static lotto.Game.*;

public class WinningLogic {
    private static Integer match;
    private static Boolean bonus;
    private static double total = 0.0F;
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
        for(Winning winning: Winning.values()){
            if((winning.bonus.equals(bonus))&(winning.match.equals(match))){
                winning.count++;
            }
        }
    }
    private static void countMatch(Lotto lotto){
        match = 0;
        lotto.getNumbers().stream().forEach(number-> addMatch(number));
    }
    private static void addMatch(Integer number){
        if(winning.getNumbers().contains(number)){
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
