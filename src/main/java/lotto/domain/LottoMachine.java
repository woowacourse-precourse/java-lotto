package lotto.domain;

import lotto.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoMachine extends Lotto {

    private int bonusNumber;

    public LottoMachine(List<Integer> numbers) {
        super(numbers);
    }

    public static List<Integer> convertStringToNumber(String numbers) {
        List<Integer> convertNumbers = new ArrayList<>();
        validateSeparator(numbers);

        for (String number : numbers.split(",")) {
            validateIsNumber(number);
            convertNumbers.add(Integer.parseInt(number));
        }

        return convertNumbers;
    }

    public static Optional<LottoMachine> initLottoMachineNumber(String numbers) {
        return Optional.of(new LottoMachine(convertStringToNumber(numbers)));
    }

    public void addBonusNumber(String inputBonusNumber) throws IllegalArgumentException {
        validateIsNumber(inputBonusNumber);

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    //validate check
    public void validateBonusNumber(int bonusNumber) {
        validateDuplicateBonusNumber(bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    public void validateDuplicateBonusNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static void validateSeparator(String numbers) {
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.NONE_SEPARATOR_ERROR.getMessage());
        }
    }

}
