package lotto;

import java.util.Arrays;

public enum MatchLotto {

    NOTHING(0, false, 0),
    THREE(3,false,5000),
    FOUR(4,false,50000),
    FIVE(5,false,1500000),
    FIVE_BONUS(5,true,30000000),
    SIX(6,false,2000000000);

    int matchNumber;
    boolean matchBonums;
    int prize;
    MatchLotto(int matchNumber, boolean matchBonus,int prize){
        this.matchNumber = matchNumber;
        this. matchBonums = matchBonus;
        this.prize = prize;
    }

    public static MatchLotto result(int matchNumber, boolean matchBonums){
        return Arrays.stream(values())
                .filter(matchLotto -> matchLotto.matchNumber == matchNumber)
                .filter(matchLotto -> matchLotto.matchBonums == matchBonums)
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("[ERROR]"));
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
}
