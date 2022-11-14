package domain;

import java.util.*;
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

    public void printCreatedLotto() {
        List<Integer> collect = numbers.stream()
                                       .sorted()
                                       .collect(Collectors.toList());
        System.out.println(collect);
    }
}
