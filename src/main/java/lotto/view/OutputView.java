package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private final static String INPUT_AMOUNT_MASSAGE = "구입금액을 입력해 주세요.";
    private final static String CHECK_AMOUNT_MASSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_NUMBERS_MASSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MASSAGE = "보너스 번호를 입력해 주세요.";
    private final static String WINNING_STATISTICS_MASSAGE = "당첨 통계";

    public static void printInputAmount() {
        System.out.println(INPUT_AMOUNT_MASSAGE);
    }

    public static void printCheckAmount(int amount) {
        System.out.printf(CHECK_AMOUNT_MASSAGE + "%n", amount);
    }
    public static void printPurchasedNumbers(List<Lotto> purchasedNumbers) {
        for (Lotto lotto : purchasedNumbers) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

}
