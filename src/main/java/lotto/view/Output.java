package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Output {
    private static final String QUANTITY_OF_LOTTO = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String PERFORATION = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    private static final String TOTAL_PROFIT = "총 수익률은 .%1f%입니다.";

    private Output() {
    }

    public static void printQuantityOfLotto(int quantity) {
        System.out.println(quantity + QUANTITY_OF_LOTTO);
    }

    public static void printLottoTickets(Set<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(formLottoTicket(lottoTicket));
        }
    }

    private static String formLottoTicket(List<Integer> lottoTicket) {
        List<String> ticket = new ArrayList<>();
        for (Integer eachNumber : lottoTicket) {
            ticket.add(String.valueOf(eachNumber));
        }
        String openBracket = "[";
        String closeBracket = "]";
        String printFormat = String.join(",", ticket);
        return openBracket + printFormat + closeBracket;
    }

    public static void printTotalRank(Map<Integer, Integer> totalRank) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(PERFORATION);
        System.out.println(THREE_CORRECT + totalRank.get(5) + "개");
        System.out.println(FOUR_CORRECT + totalRank.get(4) + "개");
        System.out.println(FIVE_CORRECT + totalRank.get(3) + "개");
        System.out.println(FIVE_AND_BONUS_CORRECT + totalRank.get(2) + "개");
        System.out.println(SIX_CORRECT + totalRank.get(1) + "개");
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(TOTAL_PROFIT, rateOfReturn));
    }

    private static long calculateSumOfPrize(Map<Integer, Integer> totalRank) {
        long sumOfPrize = 0;
        sumOfPrize += totalRank.get(1) * 2000000000L;
        sumOfPrize += totalRank.get(2) * 30000000L;
        sumOfPrize += totalRank.get(3) * 1500000L;
        sumOfPrize += totalRank.get(4) * 50000L;
        sumOfPrize += totalRank.get(5) * 5000L;
        return sumOfPrize;
    }

    private static double calculateRateOfReturn(long sumOfPrize, int purchaseAmount) {
        double rateOfReturn = (double) sumOfPrize / (double) purchaseAmount;
        return rateOfReturn;
    }
}
