package lotto.domain;

import java.util.List;

public class WiningNumber {
    private final List<Integer> winingNumber;

    private int bonusNumber;

    public WiningNumber(List<Integer> winingNumber) {
        validateWiningNumber(winingNumber);
        this.winingNumber = winingNumber;
    }

    private void validateWiningNumber(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateOverlapNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlapNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            System.out.println("[ERROR] 로또 번호에 중복이 있으면 안됩니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
