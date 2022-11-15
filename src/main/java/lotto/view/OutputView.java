package lotto.view;

import lotto.model.Prize;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public static void printPrizeResult(Map<Prize, Integer> prizeCountResult) {
        System.out.println();
        System.out.println(Message.TOTAL.getMessage());
        System.out.println("---");
        printEachCountOfPrize(prizeCountResult);
    }

    private static void printEachCountOfPrize(Map<Prize, Integer> prizeCountResult) {
        List<Double> prizeCandidates = Prize.getPrizeCandidates();
        Collections.sort(prizeCandidates);
        for(Double key : prizeCandidates ){
            Prize prize = Prize.getPrizeByScore(key);
            printLottoResult(prize, prizeCountResult.get(prize));
        }
    }

    private static void printLottoResult(Prize prize, Integer count) {
        System.out.printf(prize.getMessage());
        System.out.printf(" - %d개", count);
        System.out.println();
    }
}