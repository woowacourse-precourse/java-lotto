package lotto.check;

import lotto.Game;

public class Check {
    public static void checkBonus(int bonus){
        if(Game.luckyNumber.contains(bonus)){
            Game.bonusLuckyCount++;
            Game.fiveLuckyCount = -1;
        }
    }
}
