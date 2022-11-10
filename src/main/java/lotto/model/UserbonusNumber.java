package lotto.model;

public class UserbonusNumber {

    private final int BONUS_NUMBER;

    public UserbonusNumber(String userInput) {
        validate(userInput);
        this.BONUS_NUMBER = Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        Utility.intValidate(userInput);
    }


}
