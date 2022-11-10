package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries generateLotteriesByPrice(int totalPrice) {
        List<Lotto> lotteries = new ArrayList<>();
        int count = totalPrice / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lotteries.add(lotto);
        }

        return new Lotteries(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
