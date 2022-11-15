package lotto.controller;

import java.util.HashMap;
import java.util.Map;

public enum WinningPrize {
    FIRST(1,2_000_000_000, 6),
    SECOND(2,30_000_000,5),
    THIRD(3,1_500_000,5),
    FOURTH(4,50_000,4),
    FIFTH(5,5_000,3);

    private final int ranking;
    private final int winningMoney;
    private final int howManyNumbersIncluded;

    WinningPrize(int ranking,int winningMoney, int howManyNumbersIncluded) {
        this.ranking = ranking;
        this.winningMoney = winningMoney;
        this.howManyNumbersIncluded = howManyNumbersIncluded;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getHowManyNumbersIncluded() {
        return howManyNumbersIncluded;
    }

    public static int findRanking(int amountOfCorrectNumbers, Lotto oneLottoPaper, int bonusNumber){
        boolean isThirdPrize = (amountOfCorrectNumbers == 5) && !isBonusNumberIncludedInPapers(oneLottoPaper,bonusNumber);

        if(isThirdPrize){
            return 3;
        }

        for(WinningPrize prize : WinningPrize.values()){
            if(amountOfCorrectNumbers == prize.howManyNumbersIncluded){
                return prize.ranking;
            }
        }
        return -1;
    }

    public static WinningPrize findEnumByRank(final int ranking){
        Map<Integer, WinningPrize> forFindingEnumByRank = forFindingEnumByRank();
        return forFindingEnumByRank.get(ranking);
    }

    private static boolean isBonusNumberIncludedInPapers(Lotto oneLottoPaper, int bonusNumber){
        return oneLottoPaper.getNumbers().contains(bonusNumber);
    }

    private static Map<Integer, WinningPrize> forFindingEnumByRank(){
        // enum 순회 하면서, ranking 을 키로 하고, 들어있는 숫자를 value 로 하는 맵 만들기.
        Map<Integer, WinningPrize> howManyNumbers = new HashMap<>();
        for(WinningPrize prize : WinningPrize.values()){
            howManyNumbers.put(prize.ranking, prize);
        }
        return howManyNumbers;
    }
}
