package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;
    private int bonusNumber;

    private WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumber draw(List<Integer> numbers) {
        validate(numbers);
        return new WinningNumber(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (!isValidRanges(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들 중 중복된 숫자가 있습니다.");
        }
    }

    /**
     * 숫자의 범위가 1~ 45 인지 확인하는 메소드
     */
    private static boolean isValidRange(int number) {
        return number >= START_NUMBER && number <= END_NUMBER;
    }

    /**
     * 분리한 숫자들의 범위가 1 ~ 45 인지 확인하는 메소드
     */
    private static boolean isValidRanges(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(WinningNumber::isValidRange);
    }

    /**
     * 당첨 번호들 중 중복된 숫자의 여부를 확인하는 메소드
     */
    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_COUNT;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setBonusNumber(int number) {
        bonusNumber = number;
    }

    public int getMatchingCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
