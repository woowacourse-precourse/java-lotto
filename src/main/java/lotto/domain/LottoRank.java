package lotto.domain;

import lotto.utils.Constants;

public enum LottoRank {
    FIRST(6, false, Constants.FIRST_PRIZE_MONEY, 0, Constants.FIRST_PRIZE_MESSAGE),
    SECOND(5,true, Constants.SECOND_PRIZE_MONEY, 0, Constants.SECOND_PRIZE_MESSAGE),
    THIRD(5,false, Constants.THIRD_PRIZE_MONEY, 0, Constants.THIRD_PRIZE_MESSAGE),
    FOURTH(4,false, Constants.FOURTH_PRIZE_MONEY, 0, Constants.FOURTH_PRIZE_MESSAGE),
    FIFTH(3,false, Constants.FIFTH_PRIZE_MONEY, 0, Constants.FIFTH_PRIZE_MESSAGE),
    NO_PRIZE(0,false,0, 0, "");

    private final int match;
    private final int prizeMoney;
    private final String prizeMessage;
    private final boolean isBonus;
    private int winCount;



    LottoRank(int match, boolean isBonus, int prizeMoney, int winCount, String prizeMessage){
        this.match = match;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.winCount = winCount;
        this.prizeMessage = prizeMessage;
    }

    public int getMatchCount(){
        return this.match;
    }

    public boolean getIsBonus(){
        return this.isBonus;
    }

    public void addWinCount(){
        this.winCount += 1;
    }

    public int getWinCount(){
        return this.winCount;
    }

    public int getPrizeMoney(){
        return this.winCount*this.prizeMoney;
    }

    @Override
    public String toString(){
        return this.prizeMessage+this.winCount+"개";
    }
}
