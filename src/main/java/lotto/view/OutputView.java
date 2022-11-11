package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLottoPurchaseCompleteAmount(int quantity) {
        System.out.println(String.format(LOTTO_PURCHASE_COMPLETE_MESSAGE, quantity));
    }

    public static void printLottoFormatting(List<Lotto> purchaseLotto) {
        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.toString());
        }
    }
}
