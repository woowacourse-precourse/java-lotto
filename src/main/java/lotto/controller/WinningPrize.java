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

    public static int findRanking(int amountOfCorrectNumbers, Lotto lottoPapers, int bonusNumber){
        boolean isSecondPrize = (amountOfCorrectNumbers == 5) && isBonusNumberIncludedInPapers(lottoPapers,bonusNumber);

        for(WinningPrize prize : WinningPrize.values()){
            if(amountOfCorrectNumbers == prize.howManyNumbersIncluded){
                if(isSecondPrize){
                    return 2;
                }
                return prize.ranking;
            }
        }
        return -1;
    }

    private static boolean isBonusNumberIncludedInPapers(Lotto lottoPapers, int bonusNumber){
        return lottoPapers.getNumbers().contains(bonusNumber);
    }


    private static Map<Integer, Integer> findHowManyNumbersByRank(){
        // enum 순회 하면서, ranking 을 키로 하고, 들어있는 숫자를 value 로 하는 맵 만들기.
        Map<Integer, Integer> howManyNumbers = new HashMap<>();
        for(WinningPrize prize : WinningPrize.values()){
            howManyNumbers.put(prize.ranking, prize.howManyNumbersIncluded);
        }
        return howManyNumbers;
    }

    public static WinningPrize findHowManyNumbers(final int ranking){
        Map<Integer, Integer> howManyNumbers = findHowManyNumbersByRank();
        return WinningPrize.valueOf(String.valueOf(howManyNumbers.get(ranking)));
    }


    private static Map<Integer, Integer> findWinningMoneyByRank(){
        Map<Integer, Integer> winningMoney = new HashMap<>();
        for(WinningPrize prize : WinningPrize.values()){
            winningMoney.put(prize.ranking, prize.winningMoney);
        }
        return winningMoney;
    }

    public static WinningPrize findWinningMoney(final int ranking){
        Map<Integer, Integer> winningMoney = findWinningMoneyByRank();
        return WinningPrize.valueOf(String.valueOf(winningMoney.get(ranking)));
    }

}
