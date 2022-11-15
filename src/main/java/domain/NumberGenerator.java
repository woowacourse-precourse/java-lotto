package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static util.Constant.MAXIMUM_NUMBER;
import static util.Constant.MINIMUM_NUMBER;

// 로또의 당첨 번호 발급을 위해 중복되지 않는 6개의 범위 내 숫자를 생성하는 기능을 담당하는 클래스
public class NumberGenerator {

    public static List<Integer> createUniqueRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, 6);
        return lottoNumbers.stream()
                .sorted(Comparator.comparing(Math::abs))
                .collect(Collectors.toList());
    }
}
