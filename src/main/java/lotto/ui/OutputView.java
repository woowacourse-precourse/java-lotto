package lotto.ui;

import java.util.List;
import lotto.vo.Lotto;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNER_STAT = "당첨통계";


    public void printPurchaseMessage(int lottoGameCount) {
        System.out.println(lottoGameCount + PURCHASE_MESSAGE);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        lottoNumbers.stream()
            .forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void inputValue(String input) {
        System.out.println(input);
    }

    public void printWinnerStat() {
        System.out.println(WINNER_STAT);
    }


}
