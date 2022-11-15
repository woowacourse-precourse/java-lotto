package lotto.view;

import java.util.List;

public class OutputView {
    private static final int THREE_MATCHES = 3;
    private static final int FOUR_MATCHES = 4;
    private static final int FIVE_MATCHES = 5;
    private static final int FIVE_AND_BONUS_MATCHES = 100;
    private static final int SIX_MATCHES = 6;
    private static final int THREE_MATCH_INDEX = 0;
    private static final int FOUR_MATCH_INDEX = 1;
    private static final int FIVE_MATCH_INDEX = 2;
    private static final int SIX_MATCH_INDEX = 3;
    private static final int FIVE_AND_BONUS_MATCH_INDEX = 4;

    public static void printEnterPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
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
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningTickets(List<Integer> ticketResult) {
        System.out.println("당첨 통계\n---");
        System.out.println(THREE_MATCHES + "개 일치 (5,0000원) - "
                + ticketResult.get(THREE_MATCH_INDEX) + "개");
        System.out.println(FOUR_MATCHES + "개 일치 (50,0000원) - "
                + ticketResult.get(FOUR_MATCH_INDEX) + "개");
        System.out.println(FIVE_MATCHES + "개 일치 (1,500,0000원) - "
                + ticketResult.get(FIVE_MATCH_INDEX) + "개");
        System.out.println(FIVE_MATCHES + "개, 보너스 볼 일치 (30,000,000원) - "
                + ticketResult.get(FIVE_AND_BONUS_MATCH_INDEX) + "개");
        System.out.println(SIX_MATCHES + "개 일치 (2,000,000,000원) - "
                + ticketResult.get(SIX_MATCH_INDEX) + "개");
    }

    public static void printLottoYield(double lottoYield) {
        System.out.print("총 수익률은 " + Math.round(lottoYield * 1000) / 10.0 + "%입니다.");
    }
}
