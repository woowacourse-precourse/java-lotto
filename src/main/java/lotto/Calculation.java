package lotto;

import java.util.Arrays;
import java.util.List;

public class Calculation {
    public static Integer calculateNumberOfLottoes(Integer enteredMoney) {
        int numberOfLottoes = enteredMoney / 1000;
        return numberOfLottoes;
    }

    public enum InformationOfRank{
        FIRST(6, false, 2000000000),
        SECOND(5, true, 30000000),
        THIRD(5, false, 1500000),
        FOURTH(4, true, 50000),
        FIFTH(3, false, 5000),
        LOSE(0,false,0);


        private final int matchNumber;
        private final boolean bonusMatch;
        private final int prizeMoney;

        InformationOfRank(int matchNumber, boolean bonusMatch, int prizeMoney){
            this.matchNumber = matchNumber;
            this.bonusMatch = bonusMatch;
            this.prizeMoney = prizeMoney;
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

    

}
