package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.IssuedLotto;
import lotto.domain.WinningResult;

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
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printResult(WinningResult result, int money) {
        System.out.println("\n당첨 통계\n---");
        System.out.print(result);
        System.out.println("총 수익률은 " + result.getRateOfReturn(money) + "%입니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
