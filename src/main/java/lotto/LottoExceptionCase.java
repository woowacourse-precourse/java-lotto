package lotto;

import java.util.List;

public interface LottoExceptionCase {
    public void validateInputEmpty(String number);
    public void validateRangeBonusNumber(int bonusNumber);
    public void validateContainsBonusNumber(int bonusNumber, List<Integer> numbers);
    public void validateCharacter(char inputSequence);
    public void validateDuplicate(List<Integer> numbers);
    public void validateNumberRange(List<Integer> numbers);
    public void validateInputValue(String winningNumber);
    public void validateCommaCount(String winningNumber);
    public void validateDuplicateComma(char sequence1, char sequence2);
    public void validateLastIndexIsComma(String winningNumber);
    public void validateFirstIndexIsComma(String winningNumber);
}