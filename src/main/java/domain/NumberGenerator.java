package domain;

import camp.nextstep.edu.missionutils.Randoms;
import util.Constant;

import java.util.*;
import java.util.stream.Collectors;

import static util.Constant.MAXIMUM_NUMBER;
import static util.Constant.MINIMUM_NUMBER;

public class NumberGenerator {

    public static List<Integer> createUniqueRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, 6);
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(Math::abs))
                .collect(Collectors.toList());
    }
}
