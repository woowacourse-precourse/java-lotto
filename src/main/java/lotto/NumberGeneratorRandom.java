package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGeneratorRandom implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
