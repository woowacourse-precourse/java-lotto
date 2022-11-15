package view;

import domain.Lotto;
import domain.LottoResult;
import domain.PurchaseMoney;
import domain.WinningPrize;

import java.text.DecimalFormat;

public class UserOutputView {
    static final String WINNING_STATICS = "당첨 통계";
    static final String DOT = "---";
    static final String FIFTH_PRIZE_RESULT = "3개 일치 (%s원) - %d개\n\n";
    static final String FOURTH_PRIZE_RESULT = "4개 일치 (%s원) - %d개\n";
    static final String THIRD_PRIZE_RESULT = "5개 일치 (%s원) - %d개\n";
    static final String SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    static final String FIRST_PRIZE_RESULT = "6개 일치 (%s원) - %d개\n";
    static final String CALCULATE_YIELD_RATE = "총 수익률은 %s%%입니다.\n";
    static final String CALCULATE_PURCHASE_LOTTO = "\n%d개를 구매했습니다.\n";

    public static void printPurchaseLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATICS);
        System.out.println(DOT);
        System.out.printf(FIFTH_PRIZE_RESULT, WinningPrize.FIFTH_PRIZE.getStringPrize(), lottoResult.getThreeCount());
        System.out.printf(FOURTH_PRIZE_RESULT, WinningPrize.FOURTH_PRIZE.getStringPrize(), lottoResult.getFourCount());
        System.out.printf(THIRD_PRIZE_RESULT, WinningPrize.THIRD_PRIZE.getStringPrize(), lottoResult.getFiveCount());
        System.out.printf(SECOND_PRIZE_RESULT, WinningPrize.SECOND_PRIZE.getStringPrize(), lottoResult.getFiveAndBonusCount());
        System.out.printf(FIRST_PRIZE_RESULT, WinningPrize.FIRST_PRIZE.getStringPrize(), lottoResult.getSixCount());
        System.out.printf(CALCULATE_YIELD_RATE, lottoResult.getYield());
    }

    public static void printPurchaseNumber(PurchaseMoney purchaseMoney) {
        System.out.printf(CALCULATE_PURCHASE_LOTTO, purchaseMoney.getNumberLotteryPurchasesAvailable());
    }
}
