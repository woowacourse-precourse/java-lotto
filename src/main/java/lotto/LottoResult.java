package lotto;

import java.util.*;

public class LottoResult {

    public static int compareLotteryNumbers(List<Integer> winningNumber, List<Integer> ticketNumber) {
        int matchCount = 0;
        for (int numberIndex = 0; numberIndex < 6; numberIndex++) {
            if (ticketNumber.contains(winningNumber.get(numberIndex))) {
                matchCount++; // 티켓 당 몇개가 맞았는지 적혀있는 리스트 생성
            }
        }
        return matchCount;
    }

    public static LinkedHashMap<Integer, Integer> compareResult(List<Integer> winningNumber, List<List<Integer>> ticketNumber) {
        LinkedHashMap<Integer, Integer> resultByMatchedNumber = new LinkedHashMap<>();
        List<Integer> results = new ArrayList<>();

        for(int ticketIndex=0; ticketIndex<ticketNumber.size(); ticketIndex++){
            results.add(compareLotteryNumbers(winningNumber,ticketNumber.get(ticketIndex)));
        }

        for (int matchingNumbers = 3; matchingNumbers < 7; matchingNumbers++) {
            resultByMatchedNumber.put(matchingNumbers,Collections.frequency(results, matchingNumbers));
        }
        return resultByMatchedNumber;
    }

    public static int earningRatioCalculator(int totalMoney, int totalPrize) {
        int earnedRatio = totalPrize / totalMoney * 100;
        return earnedRatio;
    }



}
