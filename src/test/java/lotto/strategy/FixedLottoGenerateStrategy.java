package lotto.strategy;

import java.util.List;

public class FixedLottoGenerateStrategy implements LottoGenerateStrategy {

    @Override
    public List<Integer> generateLotto() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
