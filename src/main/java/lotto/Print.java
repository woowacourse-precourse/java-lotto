package lotto;

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

    public static void printResult(Map<Numbers, Integer> ranking) {
        printEmptyLine();
        System.out.println("당첨 통계\n" + "---");
        for (Numbers num : ranking.keySet()) {
            if (num == Numbers.FIVE_WITH_BONUS) {
                System.out.println(
                        num.getCount() + "개 일치, 보너스 볼 일치 (" +
                                num.getAmount() + "원) - " +
                                ranking.get(num) + "개");
                continue;
            }
            System.out.println(
                    num.getCount() + "개 일치 (" +
                            num.getAmount() + "원) - " +
                            ranking.get(num) + "개"
            );
        }
    }
}
