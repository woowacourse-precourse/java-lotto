package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum LottoIssuer {
    INSTANCE;
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public static Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }

}
