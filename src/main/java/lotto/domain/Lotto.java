package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int FIX_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lotto = generateLotto(numbers);
    }

    private List<LottoNumber> generateLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != FIX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 총 개수가 6이 아닙니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
        }
    }


}
