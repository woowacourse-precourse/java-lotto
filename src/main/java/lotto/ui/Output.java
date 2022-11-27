package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    public static void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            lotto.printLotto();
        }
    }

    public static void printStatistics() {

    }
}
