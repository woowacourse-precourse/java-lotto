package lotto;

public interface LotteryExceptionCase {
    void characterCheck(char sequence);
    void validateInputType(String amount);
    void validateCharacter(char inputSequence);
    void validateInputEmpty(String amount);
    void validateAmount(int amount);
    int convertStringToInteger(String amount);

    void amountInputEmptyCheck(String amount);
    void validateCharacter(String amount);
    void validateAmountForEarnings(int amount);
}