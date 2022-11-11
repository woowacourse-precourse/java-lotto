package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<List<Integer>> randomLottoNumbers = new ArrayList<>();

    public static List<List<Integer>> generateLottoNumber(int count) {
        IntStream.range(0, count).forEach((__) -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(numbers);
            randomLottoNumbers.add(numbers);
        });
        return randomLottoNumbers;
    }
}
