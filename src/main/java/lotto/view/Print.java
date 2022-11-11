package lotto.view;

import java.util.List;
import lotto.Lotto;

public final class Print {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void printPurchaseMoneyInput() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + PURCHASE_QUANTITY_MESSAGE);
    }

    public static void printPublishedLottoNumbers(List<Lotto> publishedLotto) {
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto.getSortedLottoNumbers());
        }
    }

    public static void printWinningLottoNumbersInput() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusLottoNumberInput() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    private Print() {
    }
}
