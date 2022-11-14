package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> collect = new HashSet<>(numbers);
        if (collect.size() != 6) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public Prize findPrize(LottoOfAnswer answerLotto) {
        int matchedCount = matchedNumberCounter(answerLotto);
        boolean isExistBonus = isExistBounusNumber(answerLotto);
        return matchedPrizeFinder(matchedCount,isExistBonus);
    }

    private int matchedNumberCounter(LottoOfAnswer answerLotto) {
        int count = 0;
        for (Integer number : numbers) {
            count += answerLotto.ifContainThenCountAdd(number);
        }
        return count;
    }

    private boolean isExistBounusNumber(LottoOfAnswer answerLotto) {
        boolean isExistBonus = false;
        for (Integer number : numbers) {
            isExistBonus = answerLotto.isContainBounus(!isExistBonus, number);
        }
        return isExistBonus;
    }

    private Prize matchedPrizeFinder(int matchedCount, boolean isExistBonus) {
        if (matchedCount == 6) {
            return Prize.FIRST;
        }
        if (matchedCount == 5 && isExistBonus) {
            return Prize.SECOND;
        }
        if (matchedCount == 5) {
            return Prize.THIRD;
        }
        if (matchedCount == 3) {
            return Prize.FIFTH;
        }
        if (matchedCount == 4) {
            return Prize.FOURTH;
        }
        return Prize.NONE;
    }

    public void print() {
        System.out.println(numbers.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[" + numbers.get(0));
        for (int index = 1; index < numbers.size(); index++) {
            stringBuilder.append(", ").append(numbers.get(index));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
