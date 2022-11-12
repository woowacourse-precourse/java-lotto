package lotto.view;

import java.util.List;

public class OutputView {
    public final int PRICE_PER_LOTTO = 1000;

    public void printLottoPurchaseCompleteMessage(int lottoChance) {
        System.out.println(lottoChance + "개를 구매했습니다.");
    }
}