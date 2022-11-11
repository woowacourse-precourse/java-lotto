package lotto.view;

import java.util.List;

public class OutputView {
    public static void printCashInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printIssueCount(int issueCount) {
        System.out.println(issueCount + "개를 구매했습니다.");
    }

    public static void printWinningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPlayerNumbers(List<Integer> playerNumbers) {
        System.out.println(playerNumbers);
    }
}
