package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoRandomNumberFactory {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    private static final int LOTTO_COUNT = 6;

    public List<Integer> createLottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT);
    }

}
