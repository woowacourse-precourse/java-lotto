package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String ENTER_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String ENTER_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "{0}개를 구매했습니다.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printInputMoney() {
        System.out.println(ENTER_PURCHASE_MONEY_MESSAGE);
    }

    public static void printBlank() {
        System.out.print("\n");
    }
    public static void printInputWinningLotto() {
        System.out.println(ENTER_WINNING_LOTTO_MESSAGE);
    }

    public static void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(MessageFormat.format(PURCHASE_LOTTO_COUNT_MESSAGE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        OutputView.printBlank();
    }
}