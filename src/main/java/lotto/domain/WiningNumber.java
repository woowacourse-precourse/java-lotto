package lotto.domain;

import java.util.List;

public class WiningNumber {
    private final List<Integer> winingNumber;

    private int bonusNumber;

    public WiningNumber(List<Integer> winingNumber) {
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

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
