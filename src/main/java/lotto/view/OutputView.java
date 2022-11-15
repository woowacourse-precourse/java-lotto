package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoTicket;
import lotto.model.Result;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    static DecimalFormat df = new DecimalFormat("###,###.##");
    public static void printException(Exception exception) {
        System.out.printf(exception.getMessage()+System.lineSeparator());
    }

    public static void printTicketCount(long count) {
        System.out.printf(count+"개를 구매했습니다."+System.lineSeparator());
    }

    public static void printLottoTickets(LottoTicket lottoTicket){
        for(Lotto lotto : lottoTicket.getLottoTickets()){
            System.out.printf(lotto.getNumbers().toString()+System.lineSeparator());
        }
    }


    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printLottoResult(Result result) {
        for (LottoRank lottoRank : LottoRank.getWithoutDefault()) {
            System.out.printf("%s개 일치%s(%s원) - %s개" + System.lineSeparator(),
                    df.format(lottoRank.getCorrectNumber()), printIfSecond(lottoRank),
                    df.format(lottoRank.getPrizeAmount()), df.format(result.getRankCount(lottoRank)));
        }

    }
    private static String printIfSecond(LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND)) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }
    public static void printProfit(final float profit) {
        System.out.printf("총 수익률은 %s%%입니다." + System.lineSeparator(),
                df.format(profit));
    }

}
