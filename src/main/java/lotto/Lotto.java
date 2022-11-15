package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lotto {


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
        validateDuplication(numbers);
    }

    protected void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 모두 달라야 합니다.");
        }
    }

    public MatchPair calculateMatchNumber(WinningLotto winningLotto){
        Stream<Integer> lottoStream = this.numbers.stream();
        Stream<Integer> winningStream = winningLotto.getNumbers().stream();
        int matchNumbers = (int)lottoStream.filter(lotto->winningStream.anyMatch(Predicate.isEqual(lotto)))
                .count();
        boolean matchBonusNumber = this.numbers.contains(winningLotto.getBonusNumber());
        return new MatchPair(matchNumbers,matchBonusNumber);
    }
}
