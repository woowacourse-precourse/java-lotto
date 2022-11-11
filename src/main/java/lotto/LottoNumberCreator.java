package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberCreator {

    private static LottoNumberCreator instance;

    private LottoNumberCreator() {
    }

    public static LottoNumberCreator getInstance() {
        if (instance == null) {
            instance = new LottoNumberCreator();
        }

        return instance;
    }

    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
