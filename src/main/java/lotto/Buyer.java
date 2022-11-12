package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Buyer {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_UNIT = String.format("[ERROR] 최소 구매 단위는 %s원 입니다.", MIN_BUY_UNIT);
    private static final String ERROR_RANGE = String.format("[ERROR] 로또 번호의 숫자 범위는 %d~%d까지입니다.",
            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    private static final String ERROR_SIZE = String.format("[ERROR] 당첨 번호는 %d개 입니다.", LOTTO_SIZE);
    private static final String ERROR_DUPLICATED = String.format("[ERROR] 당첨 번호는 %d개 입니다.", LOTTO_SIZE);

    private int money;
    private List<Integer> numbers;
    private int bonusNumber;

    public Buyer(int money, List<Integer> numbers, int bonusNumber) {
        validateUnit(money);
        this.money = money;
        validateNumbers(numbers);
        this.numbers = numbers;
        validateLottoRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return this.money;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateUnit(Integer money) {
        if (money % MIN_BUY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoRange(number);
        }
    }

    private void validateLottoRange(int number) {
        if (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> noDuplicated = new HashSet<>(numbers);
        if (noDuplicated.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED);
        }
    }
}
