package lotto;

import java.math.BigDecimal;
import java.util.List;

public class LottoOutStream {
    public static void showLottoResult (int[] matches) {
        System.out.print("\n" + "당첨 통계\n---\n");
        System.out.print("3개 일치 (5,000원) - " + matches[LottoGame._fifth_place] + "개\n");
        System.out.print("4개 일치 (50,000원) - " + matches[LottoGame._fourth_place] + "개\n");
        System.out.print("5개 일치 (1,500,000원) - " + matches[LottoGame._third_place] + "개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches[LottoGame._second_place] + "개\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + matches[LottoGame._first_place] + "개\n");
    }

    public static void showRateOfReturn(BigDecimal rateOfReturn) {
        System.out.print("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void showLottoList(List<Lotto> lottoes) {
        for (Lotto lotto: lottoes) {
            lotto.showNumbers();
        }
    }

    public static void outStreamLottoCount(int lottoCount) {
        System.out.print("\n" + lottoCount + "개를 구매했습니다.\n");
    }

    public static void askPurchaseAmount() {
        System.out.print("구입금액을 입력해 주세요.\n");
    }

    public static void askWinningNumber() {
        System.out.print("\n" + "당첨 번호를 입력해 주세요.\n");
    }

    public static void askBonusNumber() {
        System.out.print("\n" + "보너스 번호를 입력해 주세요.\n");
    }
}
