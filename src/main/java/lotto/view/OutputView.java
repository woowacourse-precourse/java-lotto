package lotto.view;

import lotto.domain.UserLotto;

import static lotto.constant.MessageConstant.MESSAGE_OUTPUT_COUNT;

public class OutputView {
    private static void printBlankLine() {
        System.out.println();
    }

    public static void printCountOfPurchasedLotto(UserLotto userLotto) {
        int countOfPurchasedLotto = userLotto.countOfPurchasedLotto();
        printBlankLine();
        System.out.println(countOfPurchasedLotto + MESSAGE_OUTPUT_COUNT);
    }
}
