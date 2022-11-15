package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.MoneyValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Const.*;

public class LottoMachine {

    public static List<Lotto> order(long money) {
        validate(money);
        List<Lotto> lottos = new ArrayList<>();

        long quantity = money / LOTTO_PRICE_UNIT;
        while (lottos.size() != quantity) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    private static void validate(long money) {
        MoneyValidator.check(money);
    }

    private static Lotto makeLotto() {
        return new Lotto(getSortedNumbers(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE)));
    }

    private static List<Integer> getSortedNumbers(List<Integer> numbers) {
        return new ArrayList<>(numbers)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
