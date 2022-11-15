package lotto;

import java.util.List;

public interface LottoExceptionCase {
    void validateInputEmpty(String number);
    void validateRangeBonusNumber(int bonusNumber);
    void validateContainsBonusNumber(int bonusNumber, List<Integer> numbers);
    void validateCharacter(char inputSequence);
    void validateDuplicate(List<Integer> numbers);
    void validateNumberRange(List<Integer> numbers);
    void validateInputValue(String winningNumber);
    void validateCommaCount(String winningNumber);
    void validateDuplicateComma(char sequence1, char sequence2);
    void validateLastIndexIsComma(String winningNumber);
    void validateFirstIndexIsComma(String winningNumber);
}