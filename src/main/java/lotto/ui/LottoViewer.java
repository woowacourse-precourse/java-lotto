package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;

import java.util.List;

public class LottoViewer {

    private static String LINE_FEED = "\n";

    public static void showPurchaseAmountInputText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showCountOfLottoTickets(int count) {
        printLineFeed();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void showWinningLottoNumberInputText() {
        printLineFeed();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void showBonusLottoNumberInputText() {
        printLineFeed();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showYield(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        lottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printLineFeed() {
        System.out.println();
    }

    public static void showWinningStatisticsText(LottoCount lottoCount) {
        System.out.println("3개 일치 (5,000원) - " + lottoCount.getFifth() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoCount.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoCount.getThird() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCount.getSecond() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoCount.getFirst() + "개");
    }
}
