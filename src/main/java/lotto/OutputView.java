package lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public void printNumberOfLottosPurchased(int numberOfLottosPurchased) {
        System.out.println(numberOfLottosPurchased + NUMBER_OF_LOTTOS_PURCHASED_MESSAGE);
    }

    public void printLottosList(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
