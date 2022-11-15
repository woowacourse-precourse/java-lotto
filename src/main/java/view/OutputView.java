package view;

import lotto.LottoCount;

public class OutputView {
    private static String PRINT_NUMBER_OF_LOTTO_COUNT = "%d개를 구매했습니다";

    public static void printLottoCount(LottoCount count) {
        System.out.printf(PRINT_NUMBER_OF_LOTTO_COUNT, count.getLottoCount());
    }
}
