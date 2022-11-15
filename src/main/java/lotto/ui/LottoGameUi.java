package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public class LottoGameUi {
    private static final String PAYMENT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_START_MESSAGE = "당첨 통계\n===";

    public void printPaymentRequestMessage() {
        System.out.println(PAYMENT_REQUEST_MESSAGE);
    }

    public void printWinningNumberRequestMessage() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public void printBonusNumberRequestMessage() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public void printPurchaseHistory(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.print("[");
        for (int idx = 0; idx < lottoNumbers.size() - 1; idx++) {
            System.out.print(lottoNumbers.get(idx) + ", ");
        }
        System.out.println(lottoNumbers.get(lottoNumbers.size() - 1) + "]");
    }

    public static void printResult(Map<Rank, Integer> result) {
        System.out.println(RESULT_START_MESSAGE);
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    public void printYield(double yieldRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", yieldRate) + "%입니다.");
    }
}
