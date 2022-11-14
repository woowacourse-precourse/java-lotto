package lotto;

import java.util.*;

public class LottoResult {

    public static List<Integer> compareLotteryNumbers(List<Integer> winningNumber, List<Integer> ticketNumber) {
        List<Integer> matchCount = new ArrayList<>();
        for (int numberIndex = 0; numberIndex < 6; numberIndex++) {
            if (ticketNumber.contains(winningNumber.get(numberIndex))) {
                matchCount.add(numberIndex); // 티켓 당 몇개가 맞았는지 적혀있는 리스트 생성
            }
        }
        return matchCount;
    }

    public static LinkedHashMap<Integer, Integer> compareResult(List<Integer> matchCount, int tickets) {
        LinkedHashMap<Integer, Integer> resultByRank = new LinkedHashMap<>();
        for (int matchingNumbers = 3; matchingNumbers < 7; matchingNumbers++) {
            resultByRank.put(matchingNumbers,Collections.frequency(matchCount, matchingNumbers));
        }
        return resultByRank;
    }

    public static int earningRatioCalculator(int totalMoney, int totalPrize) {
        int earnedRatio = totalPrize / totalMoney * 100;
        return earnedRatio;
    }


}
