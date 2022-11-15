package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PrizeCategory {
    THREE(" (5,000원)", 5000, 3),
    FOUR(" (50,000원)", 50000, 4),
    FIVE(" (1,500,000원)", 1500000, 5),
    SIXBONUS(", 보너스 볼 일치 (30,000,000원)", 30000000, 5),
    SIX(" (2,000,000,000원)", 2000000000, 6);


    String winningsPrint;
    int winnings;
    int matchCount;

    PrizeCategory(String winningsPrint, int winnings, int matchCount) {
        this.winningsPrint = winningsPrint;
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

    public static List<String> getWinningsPrint(){
        List<String> winningsPrint = new ArrayList<>();
        for (PrizeCategory value : PrizeCategory.values()){
            winningsPrint.add(value.winningsPrint);
        }
        return winningsPrint;
    }

    public static List<Integer> getWinnings(){
        List<Integer> winnings = new ArrayList<>();
        for (PrizeCategory value : PrizeCategory.values()){
            winnings.add(value.winnings);
        }
        return winnings;
    }

    public static List<Integer> getMatchCount(){
        List<Integer> matchCount = new ArrayList<>();
        for (PrizeCategory value : PrizeCategory.values()){
            matchCount.add(value.matchCount);
        }
        return matchCount;
    }

}
