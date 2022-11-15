package lotto.domain;

import static lotto.constant.Constant.ERROR_MESSAGE;
import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;

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
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE + "로또 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlapNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE + "로또 번호에 중복이 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            System.out.println(ERROR_MESSAGE + "로또 번호는 1부터 45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(String bonusNumber) {
        int numbers = Integer.parseInt(bonusNumber);
        validateBonusNumberBlank(bonusNumber);
        validateBonusNumberRange(numbers);
        validateBonusNumberOverlap(numbers);
        this.bonusNumber = numbers;
    }

    private void validateBonusNumberBlank(String bonusNumber){
        if (bonusNumber.isEmpty()) {
            System.out.println(ERROR_MESSAGE + "보너스 번호가 비어있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if (bonusNumber.contains(" ")) {
            System.out.println(ERROR_MESSAGE + "보너스 번호에 공백이 있으면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            System.out.println(ERROR_MESSAGE + "보너스 번호는 1부터45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberOverlap(int number) {
        if (winingNumber.contains(number)) {
            System.out.println(ERROR_MESSAGE + "보너스 번호는 로또 번호에 포함되면 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWiningNumber() {
        return winingNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
