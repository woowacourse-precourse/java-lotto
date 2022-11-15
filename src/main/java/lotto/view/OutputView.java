package lotto.view;

import lotto.enums.Message;
import java.util.List;

public class OutputView {
    private static final int THREE_MATCH_INDEX = 0;
    private static final int FOUR_MATCH_INDEX = 1;
    private static final int FIVE_MATCH_INDEX = 2;
    private static final int SIX_MATCH_INDEX = 3;
    private static final int FIVE_AND_BONUS_MATCH_INDEX = 4;

    public static void printEnterPurchaseAmount() {
        System.out.println(Message.ENTER_PURCHASE_AMOUNT);
    }

    public static void printLottoTickets(int lottoTICKETS) {
        System.out.println(lottoTICKETS + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<List<Integer>> TicketIntegration) {
        for (List<Integer> ticket : TicketIntegration) {
            System.out.println(ticket);
        }
    }

    public static void printEnterWinningNumbers() {
        System.out.println(Message.ENTER_WINNING_NUMBER);
    }

    public static void printEnterBonusNumber() {
        System.out.println(Message.ENTER_BONUS_NUMBER);
    }

    public static void printWinningTickets(List<Integer> ticketResult) {
        System.out.println(Message.TICKET_RESULT);
        System.out.println("3개 일치 (5,000원) - "
                + ticketResult.get(THREE_MATCH_INDEX) + "개");
        System.out.println("4개 일치 (50,000원) - "
                + ticketResult.get(FOUR_MATCH_INDEX) + "개");
        System.out.println("5개 일치 (1,500,000원) - "
                + ticketResult.get(FIVE_MATCH_INDEX) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + ticketResult.get(FIVE_AND_BONUS_MATCH_INDEX) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "
                + ticketResult.get(SIX_MATCH_INDEX) + "개");
    }

    public static void printLottoYield(float lottoYield) {
        System.out.print("총 수익률은 " + Math.round(lottoYield * 1000) / 10.0 + "%입니다.");
    }
}
