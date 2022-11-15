package lotto.ui;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class LottoOutStream {
    public static void showLottoResult(int[] matches) {
        System.out.print("\n" + "당첨 통계\n---\n");
        System.out.print("3개 일치 (5,000원) - " + matches[LottoGame._5th_index] + "개\n");
        System.out.print("4개 일치 (50,000원) - " + matches[LottoGame._4th_index] + "개\n");
        System.out.print("5개 일치 (1,500,000원) - " + matches[LottoGame._3rd_index] + "개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches[LottoGame._2nd_index] + "개\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + matches[LottoGame._1st_index] + "개\n");
    }

    public static void showROR(BigDecimal ror) {
        System.out.print("총 수익률은 " + getFormROR(ror) + "%입니다.");
    }

    private static String getFormROR(BigDecimal ror) {
        return new DecimalFormat("###,##0.0").format(ror);
    }

    public static void showLottoList(List<Lotto> lottoes) {
        System.out.print("\n" + lottoes.size() + "개를 구매했습니다.\n");

        for (Lotto lotto : lottoes) {
            lotto.showNumbers();
        }
    }
}
