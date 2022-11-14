package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.ValidNumbers;
import lotto.Model.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final int MIN_LOTTO_RANGE = ValidNumbers.MIN_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_RANGE = ValidNumbers.MAX_LOTTO_RANGE.getValue();
    private static final int MAX_LOTTO_SIZE = ValidNumbers.MAX_LOTTO_SIZE.getValue();

    public Lotto createRandomLotto() {
        List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, MAX_LOTTO_SIZE);

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public WinningLotto createWinningLotto(String input, int bonusNumber) {
        List<Integer> numbers = Stream.of(input.split("\\s*,\\s*"))
                .map(n -> (Integer.parseInt(n)))
                .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        return winningLotto;
    }

    public Map<Integer, Integer> compareLottoNumbers(List<Lotto> totalLotto, WinningLotto winningLotto) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (Lotto lotto : totalLotto) {
            int count = winningLotto.compareAndCount(lotto);
            Integer value = resultMap.putIfAbsent(count, 1);

            if (value != null) {
                value = resultMap.get(count);
                resultMap.put(count, value + 1);
            }
        }

        return resultMap;
    }

    public int countWinning(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = lottoNumbers.stream()
                .filter(num -> winningNumbers
                        .stream()
                        .anyMatch(Predicate.isEqual(num)))
                .collect(Collectors.toList())
                .size();

        return count;
    }
}
