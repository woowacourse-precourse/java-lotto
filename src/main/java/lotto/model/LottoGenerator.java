package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_START_NUMBER=1;
    private static final int LOTTO_END_NUMBER=45;
    private static final int NUMBER_OF_LOTTO=6;

    public List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, NUMBER_OF_LOTTO);
    }
}
