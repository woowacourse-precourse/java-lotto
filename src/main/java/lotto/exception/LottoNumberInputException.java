package lotto.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberInputException {

    private static final String PERMIT_NUM = "[0-9]+";
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    public void isInputValid(String numbers) {
        isConsistOfOnlyNumber(numbers);
        List<Integer> convertedNumbers = convertStringToIntegerList(numbers);
        isNumberSizeEqualsSix(convertedNumbers);
        isNumberInRange(convertedNumbers);
        isConsistedOfUniqueNumber(convertedNumbers);
    }

    private void isConsistOfOnlyNumber(String numbers) {
        String[] numberGroup = numbers.split(",");
        for (String number : numberGroup) {
            if (!number.matches(PERMIT_NUM)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.");
            }
        }
    }

    private List<Integer> convertStringToIntegerList(String numbers) {
        List<Integer> numberGroup = new ArrayList<>();
        String[] numberArray = numbers.split(",");

        for (String number : numberArray) {
            numberGroup.add(Integer.valueOf(number));
        }

        return numberGroup;
    }

    private void isNumberSizeEqualsSix(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리여야 합니다.");
        }
    }

    private void isNumberInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!isUserInputInLottoNumberRange(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이에 위치해야 합니다.");
            }
        }
    }

    private void isConsistedOfUniqueNumber(List<Integer> numbers) {
        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복이 있습니다.");
        }
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumberSet = new HashSet<>(numbers);
        return numbers.size() != uniqueNumberSet.size();
    }

    private boolean isUserInputInLottoNumberRange(Integer userInput) {
        if (userInput >= LOTTO_RANGE_START && userInput <= LOTTO_RANGE_END) {
            return true;
        }
        return false;
    }
}
