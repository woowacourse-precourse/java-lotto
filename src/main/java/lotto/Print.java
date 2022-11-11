package lotto;

import java.util.List;

public final class Print {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseMoneyInput() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println(quantity + PURCHASE_QUANTITY_MESSAGE);
    }

    public static void printPublishedLottoNumbers(List<Lotto> publishedLotto) {
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto.getSortedLottoNumbers());
        }
    }

    private Print() {
    }
}
