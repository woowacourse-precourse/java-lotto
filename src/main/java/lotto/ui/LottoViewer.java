package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoViewer {
    public static void showEnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showLottoPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.\n");
    }

    public static void showEnterLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void showEnterLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showYield(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    public static void showLottoNumberList(List<Lotto> lottoList) {
        IntStream.range(0, lottoList.size()).forEach(i -> System.out.println(lottoList.get(i).getNumbers()));
    }
}
