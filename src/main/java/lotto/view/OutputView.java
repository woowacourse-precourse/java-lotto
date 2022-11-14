package lotto.view;

import java.util.List;

public class OutputView {
    public void printPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningNumbers(List<Integer> winningNumbers) {
        System.out.println(winningNumbers);
    }

    public void printPredictionNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
