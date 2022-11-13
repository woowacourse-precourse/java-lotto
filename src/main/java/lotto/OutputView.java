package lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "개를 구매했습니다.";
    private static final String START_WINNING_STATICS_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %f입니다.";

    public void printNumberOfLottosPurchased(int numberOfLottosPurchased) {
        System.out.println(numberOfLottosPurchased + NUMBER_OF_LOTTOS_PURCHASED_MESSAGE);
    }

    public void printLottosList(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStartStatics() {
        System.out.println(START_WINNING_STATICS_MESSAGE);
    }

    public void printStatics(String message) {
        System.out.println(message);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
