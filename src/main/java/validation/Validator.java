package validation;

import static util.validation.ValidationUtil.areInteger;
import static util.validation.ValidationUtil.areValidNumbers;
import static util.validation.ValidationUtil.checkSize;
import static util.validation.ValidationUtil.haveDuplicatedNumbers;
import static util.validation.ValidationUtil.haveUndefinedNumber;
import static util.validation.ValidationUtil.isDuplicatedWithWinningNumbers;
import static util.validation.ValidationUtil.isInteger;
import static util.validation.ValidationUtil.isUnitsOf1000Won;
import static util.validation.ValidationUtil.isWithinValidRange;

import exception.InvalidBonusNumberException;
import exception.InvalidBonusNumberSizeException;
import exception.InvalidLottoException;
import exception.InvalidLottoSizeException;
import exception.InvalidRangeException;
import exception.LottoNumberDuplicatedException;
import exception.NotInUnitsOf1000WonException;
import exception.NotIntegerException;
import exception.UndefinedException;
import java.util.List;
import lotto.Lotto;

public class Validator {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public void validateGeneratedNumbers(List<Integer> numbers) {
        if (checkSize(numbers)) {
            throw new InvalidLottoSizeException();
        }

        if (haveDuplicatedNumbers(numbers)) {
            throw new LottoNumberDuplicatedException();
        }
    }

    public void validatePurchasePrice(String purchasePrice) {
        if (!isInteger(purchasePrice)) {
            throw new NotIntegerException();
        }

        if (!isUnitsOf1000Won(purchasePrice)) {
            throw new NotInUnitsOf1000WonException();
        }
    }

    public void validateWinningNumbers(List<String> numbers) {
        if (haveUndefinedNumber(numbers)) {
            throw new UndefinedException();
        }

        if (!areInteger(numbers)) {
            throw new NotIntegerException();
        }

        if (!areValidNumbers(numbers)) {
            throw new InvalidLottoException();
        }
    }

    public void validateBonusNumber(String bonusNumber, Lotto winningNumbers) {
        if (!isInteger(bonusNumber)) {
            throw new NotIntegerException();
        }

        if (checkSize(bonusNumber)) {
            throw new InvalidBonusNumberSizeException();
        }

        if (!isWithinValidRange(bonusNumber)) {
            throw new InvalidRangeException();
        }

        if (!isDuplicatedWithWinningNumbers(bonusNumber, winningNumbers)) {
            throw new InvalidBonusNumberException();
        }
    }
}
