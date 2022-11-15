package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int COUNT = 6;
    private static final String MISS_COUNT = "[ERROR] 당첨번호" + COUNT + "개의 숫자가 필요합니다.";
    private static final String DUPLICATE = "[ERROR] 당첨번호에 중복숫자가 있습니다";

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        noDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MINIMUM, LottoNumber.MAXIMUM, COUNT));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(MISS_COUNT);
        }
    }

    private void noDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE);
        }
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}

