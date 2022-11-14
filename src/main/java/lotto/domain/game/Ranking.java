package lotto.domain.game;

import java.text.DecimalFormat;
import java.util.Arrays;

import static lotto.view.OutputString.*;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    DEFAULT(0, false, 0);

    private int count;
    private boolean matchBonusNumber;
    private long prize;
    private String content;

    Ranking(String content){
        this.content = content;
    }

    Ranking(int count, boolean matchBonusNumber, long prize){
        this.count = count;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
    }

    public static Ranking findRanking(int count, boolean matchBonusNumber){
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.count == count && ranking.matchBonusNumber == matchBonusNumber)
                .findAny().orElse(DEFAULT);
    }

    public int getCount(){
        return count;
    }

    public boolean getMatchBonusNumber(){
        return matchBonusNumber;
    }

    public long getPrize(){
        return prize;
    }

    @Override
    public String toString(){
        DecimalFormat decFormat = new DecimalFormat(PRIZE_FORMAT.print());

        String bonusPhrases = "";
        if(matchBonusNumber){
            bonusPhrases = PHRASES_RANKING_BONUSNUMBER.print();
        }

        return String.format(PHRASES_RANKING.print(),  count, bonusPhrases, decFormat.format(prize));
    }

}
