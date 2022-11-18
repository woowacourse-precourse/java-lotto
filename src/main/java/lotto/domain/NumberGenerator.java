package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NumberGenerator {
    public List<Integer> getLottoNumber() {
        List<Integer> unmodifiableRandomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> RandomNumber = new ArrayList<>(unmodifiableRandomNumber);
        Collections.sort(RandomNumber);
        return RandomNumber;
    }
}
