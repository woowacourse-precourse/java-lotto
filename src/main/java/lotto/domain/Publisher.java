package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.LottoCode.*;

public class Publisher {

    public List<Lotto> getLottoGroup(int money) {
        validate(money);

        int count = getLottoCount(money);

        return IntStream.range(0, count)
                .mapToObj(index -> createLotto())
                .collect(Collectors.toList());
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE.getCode() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto createLotto() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getCode(),
                MAX_LOTTO_NUMBER.getCode(),
                COUNT_LOTTO_NUMBER.getCode()
        );

        return new Lotto(randomNumber.stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    private int getLottoCount(int money) {
        return money / LOTTO_PRICE.getCode();
    }

}
