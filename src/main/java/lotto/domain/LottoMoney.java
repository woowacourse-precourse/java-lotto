package lotto.domain;

public class LottoMoney {
    private int money;

    public int inputMoney(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
        int number = Integer.parseInt(input);
        if (!isDivided(number)) {
            throw new IllegalArgumentException(Error.IS_NOT_DIVIDED.getMessage());
        }
        return money;
    }

    private boolean isDivided(int number) {
        if ((number % 1000 != 0) || (number / 1000 == 0)) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        for (int digit = 0; digit < input.length(); digit++) {
            int digitNumber = input.charAt(digit) - '0';
            if (digitNumber < 0 || digitNumber > 9) {
                return false;
            }
        }
        return true;
    }
}
