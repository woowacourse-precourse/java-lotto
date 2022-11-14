package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkRightSize(numbers);
        checkUniqueNumbers(numbers);
    }

    private void checkRightSize(List<Integer> numbers) {
        if (LOTTO_NUMBERS_SIZE != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (LOTTO_NUMBERS_SIZE != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }
    }

    public Ranking getRankingByRightCountAndHasBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        boolean hasBonusNumber = numbers.contains(bonusNumber);
        Integer rightCount = winningLotto.countSameNumbers(this.numbers);
        return Ranking.findByRightCountAndHasBonusNumber(rightCount, hasBonusNumber);
    }

    public int countSameNumbers(List<Integer> userNumbers) {
        List<Integer> userLotto = new ArrayList<>(userNumbers);
        userLotto.retainAll(numbers);
        return userLotto.size();
    }

    @Override
    public String toString() {
        return this.numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
