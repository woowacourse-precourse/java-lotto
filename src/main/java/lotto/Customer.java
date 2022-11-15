package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.Const.*;
import static lotto.ErrorPhrase.DUPLICATE;
import static lotto.ErrorPhrase.WRONG_PAY;
import static lotto.ErrorPhrase.WRONG_INPUT;
import static lotto.ErrorPhrase.WRONG_RANGE;


public class Customer {
    private Lotto winningNumber;
    private int bonusNumber;

    public Customer() {
    }

    public int buy(String input) {
        input = removeLeadingAndTrailingSpaces(input);
        payValidate(input);
        return Integer.parseInt(input) / BILL;
    }

    public void inputWinningNumber(String input) {
        convertInputToLotto(input);
    }

    public void inputBonusNumber(String input) {
        input = removeLeadingAndTrailingSpaces(input);
        bonusNumberValidate(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void convertInputToLotto(String input) {
        StringTokenizer delimitedInput = commaDelimited(input);
        List<Integer> numbers = new ArrayList<>();

        while (delimitedInput.hasMoreTokens()) {
            String number = removeLeadingAndTrailingSpaces(delimitedInput.nextToken());
            isContainNumber(number);
            numbers.add(Integer.parseInt(number));
        }

        winningNumber = new Lotto(numbers);
    }

    private void bonusNumberValidate(String input) {
        isContainNumber(input);
        isNotWrongRange(input);
        isDuplicate(input);
    }

    private void isDuplicate(String input) {
        if (this.winningNumber.getNumbers().contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(DUPLICATE.toString());
        }
    }

    private void payValidate(String input) {
        isContainNumber(input);
        isNotWrongPay(input);
    }

    private void isNotWrongRange(String input) {
        isContainNumber(input);
        int stringToInt = Integer.parseInt(input);

        if (!(1 <= stringToInt && stringToInt <= 45)) {
            throw new IllegalArgumentException(WRONG_RANGE.toString());
        }
    }

    private void isContainNumber(String input) {
        boolean wrongInput = false;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!('0' <= character && character <= '9')) {
                wrongInput = true;
            }
        }

        if (wrongInput) {
            throw new IllegalArgumentException(WRONG_INPUT.toString());
        }
    }

    private void isNotWrongPay(String pay) {
        int stringToInt = Integer.parseInt(pay);

        if (stringToInt % BILL != 0) {
            throw new IllegalArgumentException(WRONG_PAY.toString());
        }
    }

    private StringTokenizer commaDelimited(String input) {
        return new StringTokenizer(input, ",");
    }

    private String removeLeadingAndTrailingSpaces(String input) {
        return input.trim();
    }

    public Lotto getWinningNumber() {
        return this.winningNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
