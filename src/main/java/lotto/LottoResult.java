package lotto;

import java.util.*;

public class LottoResult {

    public static int compareLotteryNumbers(List<Integer> winningNumber, List<Integer> ticketNumber) {
        int matchCount = 0;
        for (int numberIndex = 0; numberIndex < 6; numberIndex++) {
            if (ticketNumber.contains(winningNumber.get(numberIndex))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static LinkedHashMap<Integer, Integer> compareResult(List<Integer> winningNumber, List<List<Integer>> ticketNumber, int bonusNumber) {
        LinkedHashMap<Integer, Integer> resultByMatchedNumber = new LinkedHashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int ticketIndex = 0; ticketIndex < ticketNumber.size(); ticketIndex++) {
            int counter = compareLotteryNumbers(winningNumber, ticketNumber.get(ticketIndex));
            if (counter == 5 && ticketNumber.get(ticketIndex).contains(bonusNumber)) {
                counter = 7;
            }
            results.add(counter);
        }

        for (int matchingNumbers = 3; matchingNumbers < 8; matchingNumbers++) {
            resultByMatchedNumber.put(matchingNumbers, Collections.frequency(results, matchingNumbers));
        }

        return resultByMatchedNumber;
    }
    public static int sumOfAllPrizes(LinkedHashMap<Integer, Integer> lotteryResult){
        PrizeList prize[] = PrizeList.values();
        int sum=0;
        for(PrizeList prizeRank :prize) {
            sum += lotteryResult.get(prizeRank.matchedNumbers()) * prizeRank.money();
        }
        return sum;
    }
    public static int earningRatioCalculator(int totalMoney, int totalPrize) {
        int earnedRatio = totalPrize / totalMoney * 100;
        return earnedRatio;
    }


    public static void lotteryStatistics(LinkedHashMap<Integer, Integer> resultList) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (%d원) - %d개", PrizeList.FIFTH.money(), resultList.get(3));
        System.out.printf("4개 일치 (%d원) - %d개", PrizeList.FOURTH.money(), resultList.get(4));
        System.out.printf("5개 일치 (%d원) - %d개", PrizeList.THIRD.money(), resultList.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개", PrizeList.SECOND.money(), resultList.get(7));
        System.out.printf("6개 일치 (%d원) - %d개", PrizeList.FIRST.money(), resultList.get(6));
    }

}


