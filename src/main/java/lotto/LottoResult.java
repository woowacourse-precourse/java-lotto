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

    public static LinkedHashMap<Integer, Integer> compareResult(List<Integer> winningNumber, List<List<Integer>> ticketNumber,int bonusNumber) {
        LinkedHashMap<Integer, Integer> resultByMatchedNumber = new LinkedHashMap<>();
        List<Integer> results = new ArrayList<>();

        for(int ticketIndex=0; ticketIndex<ticketNumber.size(); ticketIndex++){
            int counter= compareLotteryNumbers(winningNumber,ticketNumber.get(ticketIndex));
            if(counter==5 && ticketNumber.get(ticketIndex).contains(bonusNumber)){
                counter = 7;
            }
            results.add(counter);
        }

        for (int matchingNumbers = 3; matchingNumbers < 8; matchingNumbers++) {
            resultByMatchedNumber.put(matchingNumbers,Collections.frequency(results, matchingNumbers));
        }

        return resultByMatchedNumber;
    }

    public static int earningRatioCalculator(int totalMoney, int totalPrize) {
        int earnedRatio = totalPrize / totalMoney * 100;
        return earnedRatio;
    }

 /*    public static void lotteryPrize(LinkedHashMap<Integer, Integer> resultList){
        PrizeList prizes[] = PrizeList.values();

         System.out.printf("%d개 일치 (%d원) - %d개",prizeResult.rank(),prizeResult.money(),resultList.get(prizeResult.rank()));
      for(PrizeList prizeResult:prizes){
            System.out.printf("%d개 일치 (%d원) - %d개",prizeResult.rank(),prizeResult.money(),resultList.get(prizeResult.rank()));
        }

    }*/

}
