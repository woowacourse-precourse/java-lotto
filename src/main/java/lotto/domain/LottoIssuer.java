package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum LottoIssuer {
    INSTANCE;

    public static Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_SIZE);
        return new Lotto(numbers);
    }

}
