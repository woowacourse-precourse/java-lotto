package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoTicket;
import lotto.model.Result;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(long count) {
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printLottoTickets(LottoTicket lottoTicket){
        for(Lotto lotto : lottoTicket.getLottoTickets()){
            System.out.println(lotto.getNumbers().toString());
        }
    }


    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printLottoResult(Result result) {
        for (LottoRank lottoRank : LottoRank.getWithoutDefault()) {
            System.out.printf("%d개 일치%s(%d원)- %d개" + System.lineSeparator(),
                    lottoRank.getCorrectNumber(), printIfSecond(lottoRank),
                    lottoRank.getPrizeAmount(), result.getRankCount(lottoRank));
        }

    }
    private static String printIfSecond(LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND)) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }
    public static void printProfit(final float profit) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해%s라는 의미임)" + System.lineSeparator(),
                profit, printIfLoss(profit));
    }
    private static Object printIfLoss(final float profit) {
        if (profit >= 1) {
            return " 아니";
        }
        return "";
    }

}
