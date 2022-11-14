package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
    }

    public static void printYield(float yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }

    public static void printResult(LottoResults lottoResults) {
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + lottoResults.getFifthPlace() + "개\n" +
                "4개 일치 (50,000원) - " + lottoResults.getFourthPlace() + "개\n" +
                "5개 일치 (1,500,000원) - " + lottoResults.getThirdPlace() + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResults.getSecondPlace() + "개\n" +
                "6개 일치 (2,000,000,000원) - " + lottoResults.getFirstPlace() + "개");
    }

    public static void printErr(Throwable e) {
        System.out.println(e);
    }
}
