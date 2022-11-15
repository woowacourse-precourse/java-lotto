package lotto.domain;

import java.util.List;
import lotto.util.errorMessage.ErrorMessage;

public class Lotto {

    private static final int LOTTOSIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public static int countCommonNumber(Lotto winningNums, Lotto lotto) {
        return (int) lotto.numbers
            .stream()
            .filter(number -> winningNums.numbers.contains(number))
            .count();
    }

    public static boolean isBonus(Lotto lotto, int bonus) {
        return lotto.numbers.contains(bonus);
    }

    private void validateSize(List<Integer> numbers) {
        if (isDifferentSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTOSIZE_ERROR);
        }
    }

    private static boolean isDifferentSize(List<Integer> numbers) {
        return numbers.size() != LOTTOSIZE;
    }

    private void validateNumber(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (overRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTORANGE_ERROR);
            }
        });
    }

    private static boolean overRange(Integer number) {
        return number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (haveDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTONUMBER_DUPLICATE_ERROR);
        }
    }

    private static boolean haveDuplicateNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public static boolean isWinningLottoHasBouns(int bonusNum, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNum);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
