package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String AMOUNT_ERROR = "[ERROR] 금액은 1,000의 배수여야 합니다.";
    private static final String LOTTO_NUMBER_ERROR = "[ERROR] 올바르지 않은 입력입니다.";
    private static final int MAX_LOTTO_LENGTH = 6;

    int purchaseAmount;
    List<Integer> userNumbers;
    int bonusNumber;

    User() {
        this.purchaseAmount = 0;
        this.userNumbers = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public String userInput(NumberGenerator generator) {
        return generator.generate();
    }

    public int isNumberAndInRange(String number) {
        isNumber(number);
        int num = Integer.parseInt(number);
        if (!isInNumberRange(num)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
        return num;
    }

    private boolean isInNumberRange(int number) {
        return (number >= LottoValues.START_LOTTO_VALUE.getValue()
                && number <= LottoValues.MAX_LOTTO_VALUE.getValue()
        );
    }

    private void isNumber(String number) {
        String regex = "[0-9]*$";
        if (!number.matches(regex)) throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
    }

    private void isDuplicated(int number) {
        if (userNumbers.contains(number)) throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);

        userNumbers.add(number);
    }

    private boolean isMaxNumberLength() {
        return (this.userNumbers.size() == MAX_LOTTO_LENGTH);
    }

    private String[] splitUserInput(String numbers) {
        numbers = numbers.replaceAll(" ", "");
        return numbers.split(",");
    }

    private boolean isValidUserLottoNumber(String numbers) {
        String[] numberSplit = splitUserInput(numbers);

        for (String number : numberSplit) {
            int num = isNumberAndInRange(number);
            isDuplicated(num);
        }
        return isMaxNumberLength();
    }

    public List<Integer> userLottoNumbers(NumberGenerator userInputGenerator) {
        String numbers = userInput(userInputGenerator);

        if (isValidUserLottoNumber(numbers)) {
            return this.userNumbers;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
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

    public int lottoPurchaseAmount(NumberGenerator generator) {
        String input = userInput(generator);
        isNumber(input);
        int purchaseAmount = Integer.parseInt(input);

        if (isValidPurchaseAmount(purchaseAmount)) {
            int divide = purchaseAmount / LottoValues.LOTTO_AMOUNT.getValue();
            this.purchaseAmount = divide;
            return divide;
        }
        throw new IllegalArgumentException(AMOUNT_ERROR);
    }
}
