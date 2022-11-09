package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {
    }

    private static class Holder {
        public static final LottoNumberGenerator INSTANCE = new LottoNumberGenerator();
    }

    public static LottoNumberGenerator getInstance() {
        return LottoNumberGenerator.Holder.INSTANCE;
    }

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
