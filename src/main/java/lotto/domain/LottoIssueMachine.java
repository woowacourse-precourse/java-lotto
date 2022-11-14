package lotto.domain;

import static lotto.domain.Constants.Lotto.RANGE_BEGIN;
import static lotto.domain.Constants.Lotto.RANGE_END;
import static lotto.domain.Constants.Lotto.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIssueMachine {
    public static List<Lotto> issue(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 1; count <= quantity; count++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private static Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_BEGIN, RANGE_END, SIZE);
        return new Lotto(numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }
}
