package lotto;

import java.util.List;
import java.util.Map;

import static lotto.Result.*;

public class Ui {
    public static void printMsgToGetPrice() {
        System.out.println("구입 금액을 입력해주세요.");
    }

    public static void printLottoNumbers(int amount, List<Lotto> issuedLottos) {
        System.out.println(amount + "개를 구매했습니다.");
        for (Lotto lotto : issuedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printMsgToGetWinningNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printMsgToGetBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStatistics(String ratio, Map<Result, Integer> winningData) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH.getStandard() + FIFTH.getStringPrize() + winningData.get(FIFTH) + "개" );
        System.out.println(FOURTH.getStandard() + FOURTH.getStringPrize() + winningData.get(FOURTH) + "개" );
        System.out.println(THIRD.getStandard() + THIRD.getStringPrize() + winningData.get(THIRD) + "개" );
        System.out.println(SECOND.getStandard() + SECOND.getStringPrize() + winningData.get(SECOND) + "개" );
        System.out.println(FIRST.getStandard() + FIRST.getStringPrize() + winningData.get(FIRST) + "개" );
        System.out.print("총 수익률은 " + ratio +"%입니다.");
    }

}
