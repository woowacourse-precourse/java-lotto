package lotto.view;

import java.util.List;
public class OutputView {

    enum Message {
        COUNT_LOTTO("개를 구매했습니다."),
        TOTAL("당첨 통계"),
        PROFIT_PRE("총 수익률은 "),
        PROFIT_LAST("%입니다.");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void printCountOfTicket(int count) {
        System.out.println();
        System.out.printf( "%d", count);
        System.out.println(Message.COUNT_LOTTO.getMessage());
    }

    public static void printNumberOfEachLotto(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }
}