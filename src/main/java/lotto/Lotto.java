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
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
        validateDuplication(numbers);
    }

    protected void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 모두 달라야 합니다.");
        }
    }

    public MatchPair calculateMatchNumber(WinningLotto winningLotto) {
        int matchNumbers = winningLotto.calculateSameNumber(numbers);
        boolean matchBonusNumber = false;
        for(Integer number : this.numbers){
            if(winningLotto.isMatchBonusNumber(number)){
                matchBonusNumber = true;
                break;
            }
        }
        return new MatchPair(matchNumbers, matchBonusNumber);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int index = 0; index < this.numbers.size() - 1; index++) {
            stringBuilder.append(numbers.get(index));
            stringBuilder.append(", ");
        }
        stringBuilder.append(numbers.get(numbers.size() - 1));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
