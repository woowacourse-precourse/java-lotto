package lotto.domain.lottomachine.lottoticket;

import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public String countNumbersConsistentWith(WinningNumbers winningNumbers, WinningNumber bonusNumber) {
        String count = winningNumbers.countSameValue(numbers);
        String bonusCount = bonusNumber.countSameValue(numbers);
        if (isFive(count)) {
            return count + bonusCount;
        }
        return count;
    }

    private boolean isFive(String number) {
        return number.equals("5");
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
