package lotto.view;

import java.util.*;

public class Output {
    private static final String QUANTITY_OF_LOTTO = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String PERFORATION = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    private static final String PROFIT_FORMAT = "%.1f";
    private static final String PROFIT_START_SENTENCE = "총 수익률은 ";
    private static final String PROFIT_END_SENTENCE = "%입니다.";
    private static final String UNIT = "개";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String SEPARATOR = ", ";

    private Output() {
    }

    public static void printQuantityOfLotto(int quantity) {
        System.out.println(quantity + QUANTITY_OF_LOTTO);
    }

    public static void printLottoTickets(Set<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(sortRandomLottoTicket(lottoTicket));
        }
    }

    private static String sortRandomLottoTicket(List<Integer> lottoTicket) {
        List<Integer> sortedTicket = new ArrayList<>();
        for (Integer eachNumber : lottoTicket) {
            sortedTicket.add(eachNumber);
        }
        Collections.sort(sortedTicket);
        return formLottoTicket(sortedTicket);
    }

    private static String formLottoTicket(List<Integer> lottoTicket) {
        List<String> ticket = new ArrayList<>();
        for (Integer eachNumber : lottoTicket) {
            ticket.add(String.valueOf(eachNumber));
        }
        String openBracket = OPEN_BRACKET;
        String closeBracket = CLOSE_BRACKET;
        String printFormat = String.join(SEPARATOR, ticket);
        return openBracket + printFormat + closeBracket;
    }

    public static void printTotalRank(Map<Integer, Integer> totalRank) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(PERFORATION);
        System.out.println(THREE_CORRECT + totalRank.get(5) + UNIT);
        System.out.println(FOUR_CORRECT + totalRank.get(4) + UNIT);
        System.out.println(FIVE_CORRECT + totalRank.get(3) + UNIT);
        System.out.println(FIVE_AND_BONUS_CORRECT + totalRank.get(2) + UNIT);
        System.out.println(SIX_CORRECT + totalRank.get(1) + UNIT);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PROFIT_START_SENTENCE);
        System.out.printf(String.format(PROFIT_FORMAT, rateOfReturn));
        System.out.println(PROFIT_END_SENTENCE);
    }
}