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

        for (String number : numbers.split(",")) {
            validateIsNumber(number);
            convertNumbers.add(Integer.parseInt(number));
        }

        return convertNumbers;
    }

    public static Optional<LottoMachine> initLottoMachineNumber(String numbers) {
        return Optional.of(new LottoMachine(convertStringToNumber(numbers)));
    }

    public void addBonusNumber(int bonusNumber) throws IllegalArgumentException {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    //validate check
    public void validate(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    public void validateBonusNumber(int bonusNumber) {
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
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_ERROR.getMessage());
        }
    }
}
