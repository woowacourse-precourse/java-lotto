package lotto.domain;

public class LottoMoney {
    //★ 변수명, 메소드명 컨벤션 확인하기 (input, isDivided, number, IS_NOT_DIVIDED)
    //★ 메소드 분리 ? Integer.parseInt(), number / 1000 == 0
    private int money;

    public int inputMoney(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
        int number = Integer.parseInt(input);
        if (!isDivided(number)) {
            throw new IllegalArgumentException(Error.IS_NOT_DIVIDED.getMessage());
        }
        return money = number;
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

    public int getLottoQuantity() {
        return money / 1000;
    }
}
