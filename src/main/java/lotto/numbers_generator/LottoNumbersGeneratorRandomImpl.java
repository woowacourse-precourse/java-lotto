package lotto.numbers_generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGeneratorRandomImpl implements LottoNumbersGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
