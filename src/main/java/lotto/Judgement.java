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

    public static Prize judgeGrade(int sameNumberCount, int bonusNumberCount){
        if(sameNumberCount==3){
            return Prize.Fifth;
        }
        if(sameNumberCount==4){
            return Prize.Fourth;
        }
        if(sameNumberCount==5 && bonusNumberCount==0){
            return Prize.Third;
        }
        if(sameNumberCount==5 && bonusNumberCount==1){
            return Prize.Second;
        }
        if(sameNumberCount==6){
            return Prize.First;
        }
        return Prize.Invalid;
    }



    public static double calculateEarningRate(int inputMoney, int prizeMoney){
        double earningRate = (double)prizeMoney*100/(double)inputMoney;
        earningRate = Math.round(earningRate*10/10.0);
        return earningRate;
    }
}
