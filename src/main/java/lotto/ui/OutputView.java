package lotto.ui;


import lotto.domain.Lotto;

import java.util.List;

public enum OutputView {
    INSTANCE;
    private static final String LOTTO_QUANTITY_MESSAGE_FORMAT = "개를 구매했습니다";

    public static void printLottoReceipts(List<Lotto> lotteries){
        printLottoQuantity(lotteries);
        printLotteries(lotteries);
    }
    private static void printLottoQuantity(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + LOTTO_QUANTITY_MESSAGE_FORMAT);
    }

    private static void printLotteries(List<Lotto> lotteries){
        for(Lotto lotto : lotteries){
            System.out.println(lotto.toString());
        }
    }
}
