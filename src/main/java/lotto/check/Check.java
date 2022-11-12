package lotto.check;

import lotto.Game;

public class Check {
    public static final int UNIT = 1000;
    public static void checkCach(String cash){
        try{
            if(Integer.parseInt(cash) % UNIT > 0){
                //TODO : 예외처리
                throw new IllegalArgumentException();

            }
        }catch (NumberFormatException e){
            // TODO : 예외처리
            throw new NumberFormatException();
        }
    }

    public static void checkBonusNumber(String bonus){
        if(Game.luckyNumber.contains(Integer.parseInt(bonus))){
            // TODO : 예외처리
            throw new IllegalArgumentException();
        }
    }

}
