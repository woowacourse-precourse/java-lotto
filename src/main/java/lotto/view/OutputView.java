package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_TICKET_AMOUNT = "개를 구매했습니다.";
    private static final String WINNING_STATUS = "당첨 통계";
    private static final String LINE = "---";
    private static final String COUNT = "개";
    private static final String WINNING_FIFTH = "3개 일치 (5,000원) - ";
    private static final String WINNING_FOURTH = "4개 일치 (50,000원) - ";
    private static final String WINNING_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String WINNING_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_FIRST = "6개 일치 (2,000,000,000원) - ";

    public static void lottoTicketAmountMessage(int ticket) {
        System.out.println(ticket + LOTTO_TICKET_AMOUNT);
    }

    public static void printLottoTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            List<Integer> numbers = ticket.getNumbers();
            System.out.println(numbers);
        }
    }

    public static void printPrize(List<Integer> prize) {
        System.out.println(WINNING_STATUS);
        System.out.println(LINE);
        for(int i = 0; i < prize.size(); i++) {
            if(i == 0) {
                System.out.println(WINNING_FIFTH + prize.get(i) + COUNT);
            }

            if(i == 1) {
                System.out.println(WINNING_FOURTH + prize.get(i) + COUNT);
            }

            if(i == 2) {
                System.out.println(WINNING_THIRD + prize.get(i) + COUNT);
            }

            if(i == 3) {
                System.out.println(WINNING_SECOND + prize.get(i) + COUNT);
            }

            if(i == 4) {
                System.out.println(WINNING_FIRST + prize.get(i) + COUNT);
            }
        }
    }
}
