package lotto.domain;

import lotto.domain.enums.ErrorMessage;
import java.util.List;

public class Lotto {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String NUMBER_RANGE_ERR = "[ERROR] 로또 숫자는 " + MIN_NUM + " 이상 " + MAX_NUM + "이하의 숫자만 가능합니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorMessage.NUMBER_SIZE_ERR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERR_MESSAGE.getErrorMessage());
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println(ErrorMessage.NUMBER_DUPLICATE_ERR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERR.getErrorMessage());
        }
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            System.out.println(NUMBER_RANGE_ERR);
            throw new IllegalArgumentException(NUMBER_RANGE_ERR);
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public boolean checkBounsInclude(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public int checkRaffle(Lotto pickNumber) {
        List<Integer> tempList = numbers;
        tempList.retainAll(pickNumber.numbers);
        return tempList.size();
    }
}
