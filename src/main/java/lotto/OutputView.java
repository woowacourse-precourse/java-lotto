package lotto;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_COUNT_MSG = "개를 구매했습니다.";

    public static int getLottoCount(String purchaseAmount, int unit) {
        int lottoCount = Integer.getInteger(purchaseAmount) / unit;
        System.out.println(lottoCount + OUTPUT_COUNT_MSG);
        return lottoCount;
    }

    public static void showLottoSheets(List<Lotto> userLotto) {
        for (Lotto numbers : userLotto) {
            System.out.println(numbers.toString());
        }
    }
}
