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

    private void validateOverlapNumbers(List<Integer> numbers){
        if (numbers.stream().distinct().count()!=6){
            System.out.println("[ERROR] 로또 번호에 중복이 있으면 안됩니다.");
        }
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
