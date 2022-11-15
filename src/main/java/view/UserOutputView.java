package view;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.PurchaseMoney;
import lotto.WinningPrize;

public class UserOutputView {
    static final String WINNING_STATICS = "당첨 통계";
    static final String DOT = "---";
    static final String FIFTH_PRIZE_RESULT = "3개 일치 (%s원) - %d개\n\n";
    static final String FOURTH_PRIZE_RESULT = "4개 일치 (%s원) - %d개\n";
    static final String THIRD_PRIZE_RESULT = "5개 일치 (%s원) - %d개\n";
    static final String SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    static final String FIRST_PRIZE_RESULT = "6개 일치 (%s원) - %d개\n";
    static final String CALCULATE_YIELD_RATE = "총 수익률은 %.1f%%입니다.\n";
    static final String CALCULATE_PURCHASE_LOTTO = "\n%d개를 구매했습니다.\n";

    public static void printPurchaseLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATICS);
        System.out.println(DOT);
        System.out.printf(FIFTH_PRIZE_RESULT, WinningPrize.FIFTH_PRIZE.getStringPrize(), lottoResult.getFifthPrizeCount());
        System.out.printf(FOURTH_PRIZE_RESULT, WinningPrize.FOURTH_PRIZE.getStringPrize(), lottoResult.getFourthPrizeCount());
        System.out.printf(THIRD_PRIZE_RESULT, WinningPrize.THIRD_PRIZE.getStringPrize(), lottoResult.getThirdPrizeCount());
        System.out.printf(SECOND_PRIZE_RESULT, WinningPrize.SECOND_PRIZE.getStringPrize(), lottoResult.getSecondPrizeCount());
        System.out.printf(FIRST_PRIZE_RESULT, WinningPrize.FIRST_PRIZE.getStringPrize(), lottoResult.getFirstPrizeCount());
        System.out.printf(CALCULATE_YIELD_RATE, lottoResult.getYield());
    }

    public static void printPurchaseNumber(PurchaseMoney purchaseMoney) {
        System.out.printf(CALCULATE_PURCHASE_LOTTO, purchaseMoney.getNumberLotteryPurchasesAvailable());
    }
}
