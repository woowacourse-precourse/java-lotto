package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_LENGTH = 6;

    public List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_LENGTH);
    }
}
