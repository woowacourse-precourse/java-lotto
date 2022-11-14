package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Const.*;

public class LottoMachine {

    public static List<Lotto> order(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() != quantity) {
            lottos.add(makeLotto());
        }

        return lottos;
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
