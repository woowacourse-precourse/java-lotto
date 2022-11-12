package lotto;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private static final String NUMBERS_COUNT_ERROR_MESSAGE = "[ERROR] 번호의 개수가 6개가 아닙니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45의 번호가 아닙니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Boolean[] isIncluded = new Boolean[46];
        Arrays.fill(isIncluded, false);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_COUNT_ERROR_MESSAGE);
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
            if (isIncluded[number]) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
            isIncluded[number] = true;
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        boolean[] isIncluded = new boolean[46];
        Arrays.fill(isIncluded, false);

        winningNumbers.forEach(num -> isIncluded[num] = true);
        int count = (int) this.numbers.stream().filter(num -> isIncluded[num]).count();
        // 6개 맞춤 - 1등
        if (count == 6) {
            return 1;
        }
        // 5개 맞춤 + 보너스번호 맞춤 - 2등
        if (count == 5) {
            if (this.numbers.contains(bonusNumber)) return 2;
        }
        // 5개부터 3개맞춘것 까지 - 3등 ~ 5등
        return 6 - count + 2;
    }
}
