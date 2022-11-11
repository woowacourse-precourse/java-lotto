package lotto;

public interface LotteryExceptionCase {
    void validateInputType(String amount);
    void characterCheck(char inputSequence);
    void validateInputEmpty(String amount);
    void validateAmount(int amount);
    int convertStringToInteger(String amount);
    void characterCheck(String amount);
}