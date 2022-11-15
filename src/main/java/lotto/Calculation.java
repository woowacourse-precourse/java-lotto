package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculation {
    public static Integer calculateNumberOfLottoes(Integer enteredMoney) {
        int numberOfLottoes = enteredMoney / 1000;
        return numberOfLottoes;
    }

    public enum InformationOfRank{
        FIRST(6, false, 2000000000,1),
        SECOND(5, true, 30000000,2),
        THIRD(5, false, 1500000,3),
        FOURTH(4, true, 50000,4),
        FIFTH(3, false, 5000,5),
        LOSE(0,false,0,0);


        private final int matchNumber;
        private final boolean bonusMatch;
        private final int prizeMoney;

        private final int rank;

        InformationOfRank(int matchNumber, boolean bonusMatch, int prizeMoney, int rank){
            this.matchNumber = matchNumber;
            this.bonusMatch = bonusMatch;
            this.prizeMoney = prizeMoney;
            this.rank = rank;
        }

    }

    public static int calculateMatchNumber(List<Integer> oneLotto, List<Integer> prizeNumber){
        int matchNumber = 0;
        for (int index = 0; index < prizeNumber.size(); index++){
            if(prizeNumber.contains(oneLotto.get(index))){
                matchNumber += 1;
            }
        }
        return matchNumber;
    }

    public static boolean calculateBonusStatus(List<Integer> oneLotto, int bonusNumber) {
        return (oneLotto.contains(bonusNumber));
    }

    public static InformationOfRank calculateRank(List<Integer> oneLotto, List<Integer> prizeNumber,int bonusNumber) {
        int prizeMoney = 0;
        int match = calculateMatchNumber(oneLotto,prizeNumber);
        boolean bonus = calculateBonusStatus(oneLotto,bonusNumber);
        InformationOfRank rank =  Arrays.stream(InformationOfRank.values())
                .filter(InformationOfRank -> InformationOfRank.matchNumber == match &&
                        InformationOfRank.bonusMatch == bonus)
                .findAny()
                .orElseGet(()-> InformationOfRank.LOSE);
        //prizeMoney = rank.prizeMoney;
        return rank;
    }

    public static List<Integer> calculateWinningStatistics(List<Lotto> lottoBundle, List<Integer> prizeNumber,
                                                           int bonusNumber){
        List<Integer> eachNumberOfRank = new ArrayList<>();
        for (int number = 0; number < 6; number++){
            eachNumberOfRank.add(0);
        }
        int totalPrizeMoney = 0;
        for (int number = 0; number < lottoBundle.size(); number++ ){
            List<Integer> lotto = lottoBundle.get(number).getOneLotto();
            InformationOfRank rank = calculateRank(lotto,prizeNumber,bonusNumber);
            int rankCount = eachNumberOfRank.get(rank.rank);
            eachNumberOfRank.set(rank.rank,rankCount);
            totalPrizeMoney += rank.prizeMoney;
        }
        eachNumberOfRank.add(totalPrizeMoney);
        return eachNumberOfRank;
    }

    public static float calculateYield(int totalPrizeMoney,int purchasedMoney){
        float yield = (totalPrizeMoney / purchasedMoney) * 100;
        return yield;
    }

}
