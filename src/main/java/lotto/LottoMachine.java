package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final Integer UNIT_AMOUNT = 1000;

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Integer getNumberOfLotto(Integer purchaseAmount) {
        return (purchaseAmount / UNIT_AMOUNT);
    }

    public static List<List<Integer>> createMultipleLottoNumbers(Integer numberOfLotto) {
        return IntStream.range(0, numberOfLotto)
                .mapToObj(i -> createLottoNumbers())
                .collect(Collectors.toList());
    }
}
