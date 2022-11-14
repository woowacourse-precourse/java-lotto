package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Prize findPrize(LottoOfAnswer answerLotto) {
        int matchedCount = matchedNumberCounter(answerLotto);
        boolean isExistBonus = isExistBounusNumber(answerLotto);
        return matchedPrizeFinder(matchedCount,isExistBonus);
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

    private int matchedNumberCounter(LottoOfAnswer answerLotto) {
        int count = 0;
        for (Integer number : numbers) {
            count += answerLotto.ifContainThenCountAdd(number);
        }
        return count;
    }

    public void sortedAndPrint() {
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
