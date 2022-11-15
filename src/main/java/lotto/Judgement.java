package lotto;

import java.util.List;

public class Judgement {
    public static int buyLotto(int money) {
        int numberOfLotteries;
        numberOfLotteries = money/1000;
        return numberOfLotteries;
    }

    public static int countSameNumber(List<Integer> winningNumber, List<Integer> purchasedNumber){
        int count = 0;
        for (Integer number : purchasedNumber) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static int countBonusNumber(int bonusNumber, List<Integer> purchasedNumber) {
        int count = 0;
        if(purchasedNumber.contains(bonusNumber)){
            count = 1;
        }
        return count;
    }

    public static int judgeGrade(int sameNumberCount, int bonusNumberCount){
        if(sameNumberCount==3){
            return 5;
        }
        if(sameNumberCount==4){
            return 4;
        }
        if(sameNumberCount==5 && bonusNumberCount==0){
            return 3;
        }
        if(sameNumberCount==5 && bonusNumberCount==1){
            return 2;
        }
        if(sameNumberCount==6){
            return 1;
        }
        return -1;
    }
}
