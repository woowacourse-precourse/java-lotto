package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.";
    private final static String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

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

    public static void printLottoNumbers() {
        System.out.println(LOTTO_NUMBERS_MESSAGE);
    }

    public static void printLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
    }
}
