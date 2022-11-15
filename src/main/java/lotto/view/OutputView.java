package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String LOTTO_TICKET_AMOUNT = "개를 구매했습니다.";
    private static final String WINNING_STATUS = "당첨 통계";
    private static final String LINE = "---";
    private static final String COUNT = "개";
    private static final String WINNING_FIFTH = "3개 일치 (5,000원) - ";
    private static final String WINNING_FOURTH = "4개 일치 (50,000원) - ";
    private static final String WINNING_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String WINNING_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final String YIELD = "총 수익률은 ";
    private static final String PERCENTAGE = "%입니다.";

    public static void lottoTicketAmountMessage(int ticket) {
        System.out.println(ticket + LOTTO_TICKET_AMOUNT);
    }

    public static void printLottoTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            List<Integer> numbers = ticket.getNumbers();
            System.out.println(numbers);
        }
    }

    public static void printPrize(int[] prize) {
        System.out.println(WINNING_STATUS);
        System.out.println(LINE);
        for (int i = 0; i < prize.length; i++) {
            rank(i, 0, WINNING_FIFTH, prize);
            rank(i, 1, WINNING_FOURTH, prize);
            rank(i, 2, WINNING_THIRD, prize);
            rank(i, 3, WINNING_SECOND, prize);
            rank(i, 4, WINNING_FIRST, prize);
        }
    }

    private static void rank(int i, int x, String winning, int[] prize) {
        if (i == x) {
            System.out.println(winning + prize[x] + COUNT);
        }
    }

    public static void printYeild(float yield) {
        System.out.println(YIELD + yield + PERCENTAGE);
    }
}
