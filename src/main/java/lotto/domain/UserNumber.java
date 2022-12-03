package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserNumber {
    private final Lotto winNumbers;
    private final int bonusNumber;

    public UserNumber(String winNumbers, String bonusNumber) {
        validateWinNumbersType(winNumbers);
        validateBonusNumbers(bonusNumber);

        this.winNumbers = new Lotto(toLotto(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);

        validateSame();
    }

    private void validateWinNumbersType(String winNumber) {
        if (!winNumber.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(ErrorMessage.WIN_NUMBER_TYPE.getMessage());
        }
    }

    private void validateBonusNumbers(String bonusNumber) {
        validateBonusNumberType(bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateSame() {
        List<Integer> numbers = getWinNumbers().getNumbers();
        int bonusNumber = getBonusNumber();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_SAME.getMessage());
        }
    }

    private void validateBonusNumberType(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_TYPE.getMessage());
        }
    }

    private void validateRange(String number) {
        if (Integer.parseInt(number) < LottoNumber.MIN.getNumber()
                || Integer.parseInt(number) > LottoNumber.MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private List<Integer> toLotto(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
