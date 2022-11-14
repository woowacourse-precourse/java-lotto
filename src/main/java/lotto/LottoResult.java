package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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





 /*   public static LinkedHashMap<Integer, Integer> compareResult() {
        LinkedHashMap<String, Integer> resultList = new LinkedHashMap<>();

        int ticketSheets = 8;
        int firstPlace = 0;
        int secondPlace = 0;
        int thirdPlace = 0;
        int fourthPlace = 0;
        int fifthPlace = 0;

        List<Integer> winningNumbers = LottoNumbers.getLotteryWinningNumbers();
        List<List<Integer>> ticketNumbers = LottoTicket.paidLotteryNumberGenerator(ticketSheets);

        for (int ticketIndex = 0; ticketIndex < ticketSheets; ticketIndex++) {
            int matched = compareLotteryNumbers(winningNumbers, ticketNumbers.get(ticketIndex));
            if (matched == 6) {
                firstPlace++;
            }
            if (matched == 5) {
                secondPlace++;
                thirdPlace++;
            }
            if (matched == 4) {
                fourthPlace++;
            }
            if (matched == 3) {
                fifthPlace++;
            }
        }


    }*/

    public static int earningRatioCalculator(int totalMoney, int totalPrize) {
        int earnedRatio = totalPrize / totalMoney * 100;
        return earnedRatio;
    }


}
