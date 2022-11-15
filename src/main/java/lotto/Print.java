package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class Print {
    public static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void outputNumberOfLotto(int numberOfLottos) {
        printEmptyLine();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(LottoList lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        printEmptyLine();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult(int numberOfLottos, Map<Numbers, Integer> ranking) {
        printEmptyLine();
        double prize = 0;
        System.out.println("당첨 통계\n" + "---");
        for (Numbers num : ranking.keySet()) {
            if (num == Numbers.NOTHING) {
                continue;
            }
            if (num == Numbers.FIVE_WITH_BONUS) {
                printBonusResult(ranking, num);
                prize += num.getAmount() * ranking.get(num);
                continue;
            }
            printCommonResult(ranking, num);
            prize += num.getAmount() * ranking.get(num);
        }
        printYield(numberOfLottos, prize);
    }

    private static void printYield(int numberOfLottos, double prizeMoney) {
        int lottoAmount = numberOfLottos * 1000;
        String yield = String.format("%,.1f", (prizeMoney / lottoAmount) * 100);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private static String numberComma(double number) {
        return NumberFormat.getInstance().format(number);
    }

    private static void printCommonResult(Map<Numbers, Integer> winningResult, Numbers num) {
        System.out.println(
                num.getCount() + "개 일치 (" +
                        numberComma(num.getAmount()) + "원) - " +
                        winningResult.get(num) + "개"
        );
    }

    private static void printBonusResult(Map<Numbers, Integer> winningResult, Numbers num) {
        System.out.println(
                num.getCount() + "개 일치, 보너스 볼 일치 (" +
                        numberComma(num.getAmount()) + "원) - " +
                        winningResult.get(num) + "개");
    }
}
