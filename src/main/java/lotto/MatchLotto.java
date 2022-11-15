package lotto;

import java.util.Arrays;

public enum MatchLotto {

    FIFTH(4,false,"3개 일치 (5,000원) - ",5000),
    FOURTH(3,false,"4개 일치 (50,000원) - ",50000),
    THIRD(2,false,"5개 일치 (1,500,000원) - ",1500000),
    SECOND(1,true,"5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    FIRST(0,false,"6개 일치 (2,000,000,000원) - ",2000000000);

    int matchNumber;
    boolean matchBonums;
    int prize;
    String result;
    MatchLotto(int matchNumber, boolean matchBonus,String result, int prize){
        this.matchNumber = matchNumber;
        this. matchBonums = matchBonus;
        this.prize = prize;
        this.result = result;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonums() {
        return matchBonums;
    }

    public String getResult(){
        return result;
    }
}
