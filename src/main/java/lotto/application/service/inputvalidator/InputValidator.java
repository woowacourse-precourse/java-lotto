package lotto.application.service.inputvalidator;

import java.util.List;

public interface InputValidator {

    void validatePurchaseMoneyInteger(String lottoPurchaseMoney);

    void validatePurchaseMoneyDividable(String lottoPurchaseMoney);

    void validateIntegerValue(String inputValue);

    void validateIntegerValue(String[] inputValue);

    void validateLottoNumbersOverlap(List<Integer> numbers);

    void validateLottoNumbersLength(List<Integer> numbers);

    void winningNumbersAreNumeric(String winningNumbers);

    void validateLottoNumbersRange(int number);

    void validateBonusNumberOverlap(List<Integer> numbers, int bonusNumber);

    void validateBonusNumberRange(int bonusNumber);

    void validateLottoPurchaseMoney(String lottoPurchaseMoney);

    void validateInputLottoNumber(List<Integer> numbers);

    void validateInputBonusLottoNumber(String bonusNumber, List<Integer> numbers);
}
