package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DataProcess {
    private static final int MAXIMUM_NUMBER_OF_LOTTO = 45;
    private static final int MINIMUM_NUMBER_OF_LOTTO = 1;
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;

    public static List<List<Integer>> GetLottoNumber(int count) {
        List<List<Integer>> numbers = new ArrayList<>();
        for(int i = 0; i < count; i++)
            numbers.add(Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER_OF_LOTTO, MAXIMUM_NUMBER_OF_LOTTO, NUMBER_OF_LOTTO_NUMBER));
        return numbers;
    }
}
