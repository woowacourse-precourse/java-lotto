package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.IllegalLottoException;
import lotto.util.LottoValueRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, int lottoSize) {
        validate(numbers, lottoSize);
        this.numbers = getDescendOrderNumbers(numbers);

    }

    private static List<Integer> getDescendOrderNumbers(List<Integer> numbers) {
        List<Integer> descendOrderNumbers = new ArrayList<>(numbers);
        Collections.sort(descendOrderNumbers);
        return descendOrderNumbers;
    }

    private static void duplicateValidate(List<Integer> numbers, int lottoSize) {
        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        if (numberSet.size() != lottoSize) {
            throw new IllegalLottoException();
        }
    }

    private void validate(List<Integer> numbers, int lottoSize) {
        LottoValueRange.validate(numbers);
        duplicateValidate(numbers, lottoSize);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isSame(ResultLotto resultLotto, Rank rank) {
        return rank.getBonusCount() == this.getSpecialNumberEquals(resultLotto)
                && rank.getEqualCount() == this.getLottoEquals(resultLotto.getLotto());
    }

    private int getLottoEquals(Lotto lotto) {
        return countIfExist(lotto.getNumbers());
    }

    private int countIfExist(List<Integer> others) {
        Set<Integer> allAddNumbers = new HashSet<>(numbers);
        allAddNumbers.addAll(others);
        return others.size() + numbers.size() - allAddNumbers.size();
    }

    private int getSpecialNumberEquals(ResultLotto resultLotto) {
        return countIfExist(resultLotto.getSpecialNumbers());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
