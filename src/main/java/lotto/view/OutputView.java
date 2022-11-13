package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_PURCHASE_COMPLETE_MESSAGE = "%d개를 구매했습니다.";
    private final static String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static String START_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private final static String[] PRIZE_MONEY = {"5,000", "50,000", "1,500,000", "30,000,000", "2,000,000,000"};


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

    public static void printWinningHistory(List<Integer> result) {
        System.out.println(START_WINNING_STATISTICS_MESSAGE);
        System.out.println("---");
        for (int i = 3; i < 8; i++) {
            if (i == 6) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", i - 1, PRIZE_MONEY[i - 3], result.get(i - 3)));
                continue;
            }
            if (i == 7) {
                System.out.println(String.format("%d개 일치 (%s원) - %d개", i - 1, PRIZE_MONEY[i - 3], result.get(i - 3)));
                continue;
            }
            System.out.println(String.format("%d개 일치 (%s원) - %d개", i, PRIZE_MONEY[i - 3], result.get(i - 3)));
        }
    }
}
