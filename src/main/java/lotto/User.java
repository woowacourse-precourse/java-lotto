package lotto;

import java.util.Collections;
import java.util.List;

public class User {
    int purchaseAmount;
    Lotto userNumbers;
    int bonusNumber;

    User() {
        this.purchaseAmount = 0;
        this.bonusNumber = 0;
        this.userNumbers = new Lotto(List.of(1,2,3,4,5,6));
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    private void isNumber(String number) {
        String regex = "[0-9]*$";
        if (!number.matches(regex)){
            throw new IllegalArgumentException(Message.LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isValidPurchaseAmount(int purchaseAmount) {
        return isLottoAmountDivided(purchaseAmount)
                && atLeastCanBuyOneLotto(purchaseAmount);
    }

    private boolean atLeastCanBuyOneLotto(int purchaseAmount) {
        return ((purchaseAmount / LottoValues.LOTTO_AMOUNT.getValue()) >= 1);
    }

    private boolean isLottoAmountDivided(int purchaseAmount) {
        return ((purchaseAmount % LottoValues.LOTTO_AMOUNT.getValue()) == 0);
    }

    public int lottoPurchaseAmount(String input) {
        isNumber(input);
        int purchaseAmount = Integer.parseInt(input);

        if (isValidPurchaseAmount(purchaseAmount)) {
            int divide = purchaseAmount / LottoValues.LOTTO_AMOUNT.getValue();
            this.purchaseAmount = divide;
            return divide;
        }
        throw new IllegalArgumentException(Message.AMOUNT_ERROR.getMessage());
    }

    public int isNumberAndInRange(String number) {
        isNumber(number);
        int num = Integer.parseInt(number);
        if (!isInNumberRange(num)) {
            throw new IllegalArgumentException(Message.LOTTO_NUMBER_ERROR.getMessage());
        }
        return num;
    }

    private boolean isInNumberRange(int number) {
        return (number >= LottoValues.START_LOTTO_VALUE.getValue()
                && number <= LottoValues.MAX_LOTTO_VALUE.getValue()
        );
    }
}
