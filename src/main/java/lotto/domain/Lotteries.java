package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.Validator;

public class Lotteries {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries generateLotteriesByPrice(int totalPrice) {
        validate(totalPrice);

        List<Lotto> lotteries = new ArrayList<>();
        int count = totalPrice / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lotteries.add(lotto);
        }

        return new Lotteries(lotteries);
    }

    private static void validate (int totalPrice) {
        Validator.isMultiplesOfThousand(totalPrice);
        Validator.isZero(totalPrice);
    }

    public List<List<Integer>> getLotteries() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

}
