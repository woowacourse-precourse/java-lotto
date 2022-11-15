package lotto;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Profit {
    List<Integer> lottoNumber;
    int bonusNumber;
    public Profit(int[] lottoNumber, int bonusNumber){
        this.lottoNumber = Arrays.stream(lottoNumber).boxed().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }
    public int[] checkWinnings(int[][] lotteryBundle,int bonusNumber) {
        int[] countCaseCount = new int[8];
        for (int row = 0; row < lotteryBundle.length; row++){
            countCaseCount = countContainingNumber(lotteryBundle[row], countCaseCount,bonusNumber);
        }
        return countCaseCount;
    }
    public int[] countContainingNumber(int[] lotteryArray, int[] countCaseCount, int bonusNumber){
        List<Integer> lottery = Arrays.stream(lotteryArray).boxed().collect(Collectors.toList());
        int countBonusPoints = checkIfContainsBonusPoints(lotteryArray, bonusNumber);
        lottery.retainAll(lottoNumber);
        if (lottery.size() < 5) {
            countBonusPoints = 0;
        }
        for (WinningPrize count : WinningPrize.values()){
            if (lottery.size() == count.countOfContain){
                countCaseCount[count.countOfContain+countBonusPoints]++;
                break;
            }
        }
        return countCaseCount;
    }
    private int checkIfContainsBonusPoints(int[] lotteryArray, int bonusNumber) {
        List<Integer> lottery = Arrays.stream(lotteryArray).boxed().collect(Collectors.toList());
        if (lottery.contains(bonusNumber)){
            return 2;
        }
        return 0;
    }
    public double calculateProfitRate(int[] countCaseCount, int buyingAmount) {
        BigInteger totalWinningPrize = new BigInteger("0");
        for (int index = 3; index <= 7; index++){
            String countOfCaseString = Integer.toString(countCaseCount[index]);
            BigInteger multiplyValue = new BigInteger(countOfCaseString);
            String winningPrizeValue="0";
            if (countCaseCount[index] >= 1){
                winningPrizeValue = findWinningPrizeForCal(index);
            }
            totalWinningPrize = totalWinningPrize.add(new BigInteger(winningPrizeValue).multiply(multiplyValue));
        }
        return Math.round((totalWinningPrize.doubleValue() / (double)buyingAmount) * 1000)/1000.0 * 100;
    }
    private String findWinningPrizeForCal(int countOfContains) {
        for (WinningPrize count : WinningPrize.values()){
            if (countOfContains == count.countOfContain){
                return count.winningPrize;
            }
        }
        return "0";
    }
}
