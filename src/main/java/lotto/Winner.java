package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final static String ONLY_NUMBER = "^\\d+$";
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(String numbersWithCommas, String number) {
        String[] numbersSplited = numbersWithCommas.split(",");
        validateFormat(numbersSplited);
        winningNumbers = new Lotto(createWinningNumbersByNumbers(numbersSplited));

        validateIfNumeric(number);
        bonusNumber = Integer.valueOf(number);
        validateRange(bonusNumber);
        validateIfBonusNumberIncludedInWinningNumbers();
    }

    private List<Integer> createWinningNumbersByNumbers(String[] numbers) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String number : numbers) {
            validateIfNumeric(number);
            Integer numericValue = Integer.valueOf(number);
            validNumbers.add(numericValue);
        }
        return validNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getLottoNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateFormat(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분됩니다.");
        }
    }

    private void validateIfNumeric(String input) {
        boolean isNumber = input.matches(ONLY_NUMBER);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.");
        }
    }

    private void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.");
        }
    }

    private void validateIfBonusNumberIncludedInWinningNumbers() {
        List<Integer> numbers = winningNumbers.getLottoNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 겹치는 번호가 존재합니다.");
        }
    }
}
