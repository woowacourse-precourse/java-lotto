package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_DIGITS_COUNT.getErrorMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.NUMBER_RANGE_START || number > Constant.NUMBER_RANGE_END) {
                throw new IllegalArgumentException(InputErrorMessage.OUT_OF_RANGE_NUMBER.getErrorMessage());
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            checkDuplicateNumber(numbers, i);
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers, int index) {
        Integer uncheckedNumber = numbers.get(index);
        for (int j = index+1; j < numbers.size(); j++) {
            Integer nextNumber = numbers.get(j);
            if (uncheckedNumber.equals(nextNumber)) {
                throw new IllegalArgumentException(InputErrorMessage.DUPLICATE_NUMBERS.getErrorMessage());
            }
        }
    }

    public int countSameNumber(Lotto userLotto) {
        int sameNumberCount = 0;
        for(Integer lottoNumber: numbers) {
            if(userLotto.hasNumber(lottoNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public boolean hasNumber(Integer userLottoNumber) {
        for(Integer lottoNumber: numbers) {
            if (lottoNumber.equals(userLottoNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
