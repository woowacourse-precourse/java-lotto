package lotto.domain;

import static lotto.viewer.ErrorMessage.*;
import static lotto.viewer.ViewFormat.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int MINIMUM_NUMBER = 1;
    private static final int FIVE = 5;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateOverSize(numbers);
        validateDuplicate(numbers);
        validateOverNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList(lotto);
        Collections.sort(sortedLotto);
        return new Lotto(sortedLotto);
    }
    public static Lotto generateRandomLotto() {
        return from(Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER,MAXIMUM_NUMBER,LOTTO_SIZE));
    }

    private void validateOverSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ENTER_SIX_NUMBER);
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ENTER_UNIQUE_NUMBER);
        }
    }
    private void validateOverNumber(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().anyMatch(this::outOfRange)) {
            throw new IllegalArgumentException(ENTER_RANGE_NUMBER);
        }
    }

    boolean outOfRange(int number) {
        return number>MAXIMUM_NUMBER || number<MINIMUM_NUMBER;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Result play(WinningNumber winningNumber) {
        if (count(winningNumber) == FIVE && hasSameBonusNumber(winningNumber))
            return Result.FIVE_BONUS;
        return Result.valueOf(numbers.stream()
                .filter(winningNumber::contains)
                .count());
    }
    private boolean hasSameBonusNumber(WinningNumber winningNumber) {
        return numbers.stream()
                .anyMatch(winningNumber::sameBonusNumber);
    }
    private int count(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public String toString() {
        List<String> mappedNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return OPEN_BRACKET + String.join(COMMA,mappedNumbers) + CLOSE_BRACKET;
    }
}
