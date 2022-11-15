package view;

import lotto.Lotto;
import lotto.LottoCollection;
import lotto.LottoCount;

public class OutputView {
    private static String PRINT_NUMBER_OF_LOTTO_COUNT = "%d개를 구매했습니다";

    public static void printLottoCount(LottoCount count) {
        System.out.printf(PRINT_NUMBER_OF_LOTTO_COUNT, count.getLottoCount());
    }
    public static void printLottoCollection(LottoCollection lottoCollection){
        for (Lotto lotto : lottoCollection.copyCollection()) {
            System.out.println(lotto.copyNumbers());
        }
    }
}
