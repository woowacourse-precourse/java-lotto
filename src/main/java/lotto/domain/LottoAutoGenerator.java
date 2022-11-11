package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoAutoGenerator {
    public static List<Lotto> generateLottoCollection(int money) {
        List<Lotto> groupOfLotto = new ArrayList<>();
        int amountOfLotto = money / LottoRule.COST.getValue();

        IntStream.range(0, amountOfLotto)
                .forEach((index) -> groupOfLotto.add(generateLotto()));

        return groupOfLotto;
    }
    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MINIMUM_NUMBER.getValue(),
                LottoRule.MAXIMUM_NUMBER.getValue(),
                LottoRule.AMOUNT_OF_NUMBER.getValue()
        );
        Collections.sort(numbers);

        return Lotto.of(numbers);
    }
}
