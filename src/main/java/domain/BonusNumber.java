package domain;

import exception.BonusExceptionType;

public class BonusNumber {

    private final int BONUS_CNT = 1;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;

    public void numberCount(String input){
        if(input.length() != BONUS_CNT){
            throw new IllegalArgumentException(BonusExceptionType.NOT_MATCH_BONUS_CNT.getErrorMessage());
        }
    }

    public int convertStringToInteger(String input){
        int bonus = Integer.parseInt(input);
        return bonus;
    }

    public void numberRange(int bonus){
        if(bonus < MIN_NUMBER || bonus > MAX_NUMBER){
            throw new IllegalArgumentException(BonusExceptionType.NOT_MATCH_BONUS_RANGE.getErrorMessage());
        }
    }
}
