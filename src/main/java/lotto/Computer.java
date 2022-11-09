package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.view.ErrorMessage.ERROR_DUPLICATE;
import static lotto.view.ErrorMessage.ERROR_LOTTO_RANGE;
import static lotto.view.ErrorMessage.ERROR_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    static List<Integer> autoNumbers;

    static List<Integer> createAutoNumbers() {
        autoNumbers = pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_SIZE);
        Set<Integer> duplicates = new HashSet<>(autoNumbers);
        autoNumbers = new ArrayList<>(duplicates);
        Collections.sort(autoNumbers);
        return autoNumbers;
    }
}
