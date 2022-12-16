package lotto.domain.lotto;

import lotto.exception.ErrorPrefix;

public class Bonus {
    private int number;

    public Bonus(int number) {
        this.number = number;
    }

    public Bonus(String number) {
        validate(number);
        this.number = convertInteger(number);
    }

    private int convertInteger(String value) {
        return Integer.parseInt(value);
    }

    private void validate(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                String message = ErrorPrefix.IllegalArgumentException.getPrefix()
                        + "보너스 번호는 숫자여야합니다.";
                System.out.println(message);
                throw new IllegalArgumentException(message);
            }
        }
    }


    public int getNumber() {
        return number;
    }
}
