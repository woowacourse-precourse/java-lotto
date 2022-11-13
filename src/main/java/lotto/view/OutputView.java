package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseAmountMessage(Integer number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(Arrays.toString(lotto.getNumbers().stream().toArray()));
    }

    public static void printWinningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStatic(List<Integer> numbers, float number) {
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + numbers.get(0) + "개\n" +
                "4개 일치 (50,000원) - " + numbers.get(1) + "개\n" +
                "5개 일치 (1,500,000원) - " + numbers.get(2) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + numbers.get(3) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + numbers.get(4) + "개\n" +
                "총 수익률은 " + number + "%입니다.");
    }


}
