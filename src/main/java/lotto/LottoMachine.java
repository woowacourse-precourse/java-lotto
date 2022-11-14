package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final Integer UNIT_AMOUNT = 1000;

    public static List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static Integer getNumberOfLotto(Integer purchaseAmount) {
        return (purchaseAmount / UNIT_AMOUNT);
    }

    public static List<List<Integer>> createMultipleLottoNumbers(Integer purchaseAmount) {
        return IntStream.range(0, getNumberOfLotto(purchaseAmount))
                .mapToObj(i -> createLottoNumbers())
                .collect(Collectors.toList());
    }
}
