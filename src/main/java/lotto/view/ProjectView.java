package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.IssuedLotto;
import lotto.domain.WinningResult;

public class ProjectView {
    private static final String NEXT_LINE = "\n";

    public String askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void sell(IssuedLotto issuedLotto) {
        System.out.println(NEXT_LINE + issuedLotto.getTotalCount() + "개를 구매했습니다.");
        System.out.println(issuedLotto);
    }

    public String getWinningNumber() {
        System.out.println(NEXT_LINE + "당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(NEXT_LINE + "보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(WinningResult result, int money) {
        System.out.println(NEXT_LINE + "당첨 통계" + NEXT_LINE + "---");
        System.out.print(result);
        System.out.println("총 수익률은 " + result.getRateOfReturn(money) + "%입니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
