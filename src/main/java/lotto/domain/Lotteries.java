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

        int count = totalPrice / LottoInfo.PRICE.getNumber();
        List<Lotto> lotteries = generateLottoList(count);

        return new Lotteries(lotteries);
    }

    private static void validate(int totalPrice) {
        Validator.isMultiplesOfThousand(totalPrice);
        Validator.isUnderZero(totalPrice);
    }

    private static List<Lotto> generateLottoList(int count) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lotteries.add(lotto);
        }

        return lotteries;
    }

    public List<List<Integer>> getLotteries() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }
}