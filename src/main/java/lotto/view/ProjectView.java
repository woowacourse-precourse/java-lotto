package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.IssuedLotto;
import lotto.domain.WinningResult;

import static lotto.domain.LottoRank.*;

public class ProjectView {
    public static String askPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static void sell(IssuedLotto issuedLotto){
        System.out.println("\n" + issuedLotto.getTotalCount() + "개를 구매했습니다.");
        System.out.println(issuedLotto);
    }

    public static String getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printResult(WinningResult result, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getWinningCount(FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getWinningCount(FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getWinningCount(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getWinningCount(SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getWinningCount(FIRST) + "개");
        System.out.println("총 수익률은 " + result.getRateOfReturn(money) + "%입니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
