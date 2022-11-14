package lotto.view;

import lotto.domain.UserLotto;

public class OutputView {
    private static final String MESSAGE_PRINT_COUNT = "개를 구매했습니다.";

    private static void printBlankLine() {
        System.out.println();
    }

    public static void printCountOfPurchasedLotto(UserLotto userLotto) {
        int countOfPurchasedLotto = userLotto.countOfPurchasedLotto();
        printBlankLine();
        System.out.println(countOfPurchasedLotto + MESSAGE_PRINT_COUNT);
    }
}
