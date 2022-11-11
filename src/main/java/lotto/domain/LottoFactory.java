package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH));
    }
}
