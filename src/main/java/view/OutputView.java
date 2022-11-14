package view;

import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResult;
import lotto.Lottos;

public class OutputView {
    private static final String LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_OUTPUT_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_FIFTH_OUTPUT_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String LOTTO_FOURTH_OUTPUT_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String LOTTO_THIRD_OUTPUT_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String LOTTO_SECOND_OUTPUT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String LOTTO_FIRST_OUTPUT_MESSAGE = "6개 일치 (2,000,000,000)원 - %d개\n";
    private static final String LOTTO_YIELD_OUTPUT_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf(LOTTO_PURCHASE_COUNT_OUTPUT_MESSAGE, lottoCount);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println(LOTTO_RESULT_OUTPUT_MESSAGE);
        System.out.printf(LOTTO_FIFTH_OUTPUT_MESSAGE, lottoResult.getCountOfLottoResult(LottoRank.FIFTH_PLACE));
        System.out.printf(LOTTO_FOURTH_OUTPUT_MESSAGE, lottoResult.getCountOfLottoResult(LottoRank.FOURTH_PLACE));
        System.out.printf(LOTTO_THIRD_OUTPUT_MESSAGE, lottoResult.getCountOfLottoResult(LottoRank.THIRD_PLACE));
        System.out.printf(LOTTO_SECOND_OUTPUT_MESSAGE, lottoResult.getCountOfLottoResult(LottoRank.SECOND_PLACE));
        System.out.printf(LOTTO_FIRST_OUTPUT_MESSAGE, lottoResult.getCountOfLottoResult(LottoRank.FIRST_PLACE));
    }

    public static void printLottoYield(double yield) {
        System.out.printf(LOTTO_YIELD_OUTPUT_MESSAGE, yield);
    }
}
