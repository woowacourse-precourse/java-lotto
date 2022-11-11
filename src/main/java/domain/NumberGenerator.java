package domain;

import camp.nextstep.edu.missionutils.Randoms;
import util.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    public static List<Integer> createUniqueRandomNumbers() {
        Set<Integer> LottoNumbers = new HashSet<>();
        while (LottoNumbers.size() < 6) {
            int number = Randoms.pickNumberInRange(Constant.MINIMUM_NUMBER, Constant.MAXIMUM_NUMBER);
            LottoNumbers.add(number);
        }
        return new ArrayList<>(LottoNumbers);
    }
}
