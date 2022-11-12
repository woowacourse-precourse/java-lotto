package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.utils.LottoInfo;
import lotto.utils.Validator;

public class Lotteries {
    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries generateLotteriesByPrice(int totalPrice) {
        validate(totalPrice);

        List<Lotto> lotteries = new ArrayList<>();
        int count = totalPrice / LottoInfo.PRICE.getNumber();

        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lotteries.add(lotto);
        }

        return new Lotteries(lotteries);
    }

    private static void validate (int totalPrice) {
        Validator.isMultiplesOfThousand(totalPrice);
        Validator.isUnderZero(totalPrice);
    }

    public List<List<Integer>> getLotteries() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

}
