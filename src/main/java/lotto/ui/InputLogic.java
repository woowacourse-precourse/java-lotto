package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputLogic {
    private static int lottoIssueCount = 0;
    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.valueOf(Console.readLine());
        validatePurchaseAmount(purchaseAmount);
        lottoIssueCount = purchaseAmount / 1000;
        System.out.println();
        return purchaseAmount;
    }

    public static int getLottoIssueCount() {
        return lottoIssueCount;
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 0원보다는 커야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 1000원 단위로 나눠 떨어져야 합니다.");
        }
    }
}
