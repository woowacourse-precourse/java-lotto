package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoRandomNumberFactory {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    public List<Integer> createLottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

}
