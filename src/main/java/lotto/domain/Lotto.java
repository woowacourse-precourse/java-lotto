package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateIsDuplicate(numbers);
        validateLottoIsNumeric(numbers);
    }

    public List<Integer> countMatch(Set<Integer> winningLottoNumbers, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();
        int matchCount = 0;
        int bonusIsMatched = 0;
        for (int number : numbers) {
            matchCount += checkIsMatched(number, winningLottoNumbers);
            bonusIsMatched += checkBonusIsMatched(number, bonusNumber);
        }
        counts.add(matchCount);
        counts.add(bonusIsMatched);
        return counts;
    }

    private int checkIsMatched(int number, Set<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private int checkBonusIsMatched(int number, int bonusNumber) {
        if (number == bonusNumber) {
            return 1;
        }
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> sortAscendingLotto() {
        List<Integer> collect = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return collect;
    }

    private void validateIsDuplicate(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[Error]로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateLottoIsNumeric(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkNumberInterval(number);
        }
    }

    private void checkNumberInterval(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[Error]로또 번호는 1이상 45이하이어야 합니다.");
        }
    }
}
