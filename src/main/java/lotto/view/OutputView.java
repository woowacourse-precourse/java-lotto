package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MoneyUnit;

import java.math.BigDecimal;
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

    public static void printStatic(List<Integer> numbers, double yield) {
        System.out.print("당첨 통계\n---\n");
        for (int place = 5; place >= 1; place--) {
            System.out.println(getCollectWord(place) + " " + getPrizeMoneyWord(place) + " - " + getNumberOfWin(numbers, place));
        }
        System.out.println("총 수익률은 " + new BigDecimal(yield).toString() + "%입니다.");
    }

    private static String getCollectWord(int place) {
        if (place >= 3) {
            return 8 - place + "개 일치";
        }
        if (place == 2) {
            return "5개 일치, 보너스 볼 일치";
        }
        return "6개 일치";
    }

    private static String getPrizeMoneyWord(int place) {
        return "(" + MoneyUnit.getUnitString(place) + "원)";
    }

    private static String getNumberOfWin(List<Integer> numbers, int place) {
        return numbers.get(place) + "개";
    }
}
