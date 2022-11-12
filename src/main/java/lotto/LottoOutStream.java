package lotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoOutStream {
    public static void outStreamLottoResult (int[] matches) {
        System.out.print("당첨 통계\n---\n");
        System.out.print("3개 일치 (5,000원) - " + matches[LottoGame._fifth_place] + "개\n");
        System.out.print("4개 일치 (50,000원) - " + matches[LottoGame._fourth_place] + "개\n");
        System.out.print("5개 일치 (1,500,000원) - " + matches[LottoGame._third_place] + "개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches[LottoGame._second_place] + "개\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + matches[LottoGame._first_place] + "개\n");
    }

    public static void outStreamRateOfReturn(BigDecimal rateOfReturn) {
        System.out.print("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void outStreamLottoesNumber(List<Lotto> lottoes) {
        for (Lotto lotto: lottoes) {
            lotto.showNumbers();
        }
    }
}
