package lotto.controller;

public enum WinningPrize {
    FIRST(1,2_000_000_000, 6),
    SECOND(2,30_000_000,5),
    THIRD(3,1_500_000,5),
    FOURTH(4,50_000,4),
    FIFTH(5,5_000,3);

    private int ranking;
    private int winningMoney;
    private int howManyNumbersIncluded;

    WinningPrize(int ranking,int winningMoney, int howManyNumbersIncluded) {}

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
}
