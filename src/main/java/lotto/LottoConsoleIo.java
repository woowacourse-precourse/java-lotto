package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoConsoleIo {
    static void printRequestPurchase() {
        System.out.println("구입금액을 입력해주세요.");
    }

    static void printNoOfLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    static void printRequestWin() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    static void printRequestBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    static void printResultStatistics(List result) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(0) + "개\n" +
                "4개 일치 (50,000원) - " + result.get(1) + "개\n" +
                "5개 일치 (1,500,000원) - " + result.get(2) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(3) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + result.get(4) + "개\n" +
                "총 수익률은 " + result.get(5) + "%입니다.");
    }

    static String scanInputValue() {
        return Console.readLine();
    }

}
