package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final List<Integer> numbers;
    private int bonus;

    private WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 입력 받은 당첨 번호들로 당첨 번호 객체를 만드는 메소드
     */
    public static WinningNumber draw(List<Integer> numbers) {
        validateWinningNumber(numbers);
        return new WinningNumber(numbers);
    }

    /**
     * 입력 받은 보너스 번호를 필드 변수에 설정하는 메소드
     */
    public void addBonus(int bonus) {
        validateBonus(bonus);
        this.bonus = bonus;
    }

    /**
     * 보너스 번호를 반환하는 메소드
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * 당첨 번호의 유효성을 검사하는 메소드
     */
    private static void validateWinningNumber(List<Integer> numbers) {
        if (!isValidRanges(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들 중 중복된 숫자가 있습니다.");
        }
    }

    /**
     * 보너스 번호의 유효성을 검사하는 메소드
     */
    private void validateBonus(int bonus) {
        if (!isValidRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (isDuplicatedWithWinningNumber(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
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

    /**
     * 당첨 번호와 보너스 번호의 중복 여부를 확인하는 메소드
     */
    private boolean isDuplicatedWithWinningNumber(int bonus) {
        return numbers.contains(bonus);
    }

    /**
     * 해당 숫자가 당첨 번호에 속해 있는지 확인하는 메소드
     */
    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

}
