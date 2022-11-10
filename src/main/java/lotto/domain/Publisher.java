package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Publisher {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int COUNT_LOTTO_NUMBER = 6;
    private static final int LOTTO_PRICE = 1000;

    public List<List<Integer>> getLottoGroup(int money) {
        validate(money);

        List<List<Integer>> result;
        int count = getLottoCount(money);

        result = IntStream.range(0, count)
                .mapToObj(index -> getLottoNumber())
                .collect(Collectors.toList());

        return result;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
    }

    private int getLottoCount(int money) {
        // TODO : validate
        return money / LOTTO_PRICE;
    }

}
