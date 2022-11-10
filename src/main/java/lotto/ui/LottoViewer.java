package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoViewer {
    public static void showPurchaseAmountInputText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showCountOfLottoTickets(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void showWinningLottoNumberInputText() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void showBonusLottoNumberInputText() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void showYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        IntStream.range(0, lottoTickets.size()).forEach(index -> System.out.println(lottoTickets.get(index).getNumbers()));
    }

    public static void showWinningStatistics() {
        System.out.println("\n당첨 통계\n" + "---\n");
    }
}
