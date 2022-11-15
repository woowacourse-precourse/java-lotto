package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkLottoNumbersDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
        }
    }

    public void checkLottoNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    public static List<Integer> pickLottoNumbers () {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }
}
