package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomLottoGenerator {
    private List<Integer> numbers;

    public RandomLottoGenerator() {
    }

    public List<Integer> makeRandomLotto() {
        this.numbers
                = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(numbers);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 숫자가 6개가 아닙니다.");
        }

        Integer max = numbers.stream().max(Integer::compareTo).orElseThrow();
        Integer min = numbers.stream().min(Integer::compareTo).orElseThrow();
        if (min < 1 || max > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복됩니다.");
        }
    }
}
