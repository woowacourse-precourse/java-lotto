package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    public static final LottoGenerator getInstance = new LottoGenerator();

    public List<Lotto> issueLotto(int pages) {
        List<Lotto> lotto = new ArrayList<>();
        for (int iterator = 0; iterator < pages; iterator++) {
            Lotto numbers = new Lotto(sortLotto(createLotto()));
            lotto.add(numbers);
        }
        return lotto;
    }

    public List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        List<Integer> sort = numbers;
        sort = sort.stream()
                .sorted()
                .collect(Collectors.toList());
        return sort;
    }
}
