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

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
