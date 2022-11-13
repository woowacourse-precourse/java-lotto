package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import static lotto.Const.SIZE;
import static lotto.Const.BILL;
import static lotto.ErrorPhrase.DUPLICATE;
import static lotto.ErrorPhrase.WRONG_LENGTH;
import static lotto.ErrorPhrase.WRONG_PAY;
import static lotto.ErrorPhrase.WRONG_INPUT;
import static lotto.ErrorPhrase.WRONG_RANGE;


public class Customer {
    private List<Integer> winningNumber;
    private int bonusNumber;

    public Customer() {
    }

    public int buy(String input) {
        input = removeLeadingAndTrailingSpaces(input);
        payValidate(input);
        return Integer.parseInt(input) / BILL.getNumber();
    }

    public void inputWinningNumber(String input) {
        winningNumberValidate(input);
        convertInputToLotto(input);
    }

    public void inputBonusNumber(String input) {
        input = removeLeadingAndTrailingSpaces(input);
        bonusNumberValidate(input);
        this.bonusNumber = Integer.parseInt(input);
    }

    private void convertInputToLotto(String input) {
        StringTokenizer delimitedInput = commaDelimited(input);
        winningNumber = new ArrayList<>();

        while (delimitedInput.hasMoreTokens()) {
            winningNumber.add(Integer.parseInt(removeLeadingAndTrailingSpaces(delimitedInput.nextToken())));
        }
    }

    private void bonusNumberValidate(String input) {
        isContainNumber(input);
        isNotWrongRange(input);
    }

    private void payValidate(String input) {
        isContainNumber(input);
        isNotWrongPay(input);
    }

    public void winningNumberValidate(String input) {
        StringTokenizer delimitedInput = commaDelimited(input);

        isNotWrongLength(delimitedInput);
        delimitedInputEachNumberValidate(delimitedInput);
    }

    private void delimitedInputEachNumberValidate(StringTokenizer delimitedInput) {
        List<Integer> numbers = new ArrayList<>();

        while (delimitedInput.hasMoreTokens()) {
            String input = delimitedInput.nextToken();
            input = removeLeadingAndTrailingSpaces(input);
            isNotWrongRange(input);

            numbers.add(Integer.parseInt(input));
        }

        duplicateValidate(numbers);
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(numbers);

        if (!SIZE.equals(duplicateCheck.size())) {
            throw new IllegalArgumentException(DUPLICATE.toString());
        }
    }

    private void isNotWrongRange(String input) {
        isContainNumber(input);
        int stringToInt = Integer.parseInt(input);

        if (!(1 <= stringToInt && stringToInt <= 45)) {
            throw new IllegalArgumentException(WRONG_RANGE.toString());
        }
    }

    private void isNotWrongLength(StringTokenizer delimitedInput) {
        if (!SIZE.equals(delimitedInput.countTokens())) {
            throw new IllegalArgumentException(WRONG_LENGTH.toString());
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

        if (stringToInt % BILL.getNumber() != 0) {
            throw new IllegalArgumentException(WRONG_PAY.toString());
        }
    }
    private StringTokenizer commaDelimited(String input) {
        return new StringTokenizer(input, ",");
    }

    private String removeLeadingAndTrailingSpaces(String input) {
        return input.trim();
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
