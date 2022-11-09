package lotto.validator;

public class UserInputValidator {

    public void validateLottoPurchaseMoney(String lottoPurchaseMoney) {
        try {
            Integer.parseInt(lottoPurchaseMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
