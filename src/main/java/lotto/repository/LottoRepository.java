package lotto.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class LottoRepository {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_SIZE);
    }
}
