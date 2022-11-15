package lotto.ui;

import java.util.List;
import lotto.domain.lotto.LottoRanking;
import lotto.dto.LottoGameResult;

public class UI {

    public static void printPurchasedLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printLottoPriceGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBonusNumberGuide() {
        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
    }

    public static void printWinningLottoGuide() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
    }

    public static void printLottoGameResult(LottoGameResult lottoGameResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            Integer count = lottoGameResult.getLottoRankingCount()
                .getOrDefault(lottoRanking, 0);
            System.out.println(lottoRanking.getMessage() + count + "개");
        }
        System.out.printf("총 수익률은 %.1f%s입니다.", lottoGameResult.getProfitRatio(), "%");
    }
}
