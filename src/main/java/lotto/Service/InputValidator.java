package lotto.Service;

import lotto.Model.ValidNumbers;

public class InputValidator {

    public static final int MIN_COST = ValidNumbers.valueOf("MIN_COST").getValue();

    public static final String ERROR_HEADER = "[ERROR]";
    public static final String NUMBER_FORMAT_MESSAGE = ERROR_HEADER + " 숫자만 입력 가능합니다.";
    public static final String COST_EXCEPTION_MESSAGE = ERROR_HEADER + " 금액을 1,000원 단위로 입력해주십시오.";

    public void validate(String input) {
        int money = 0;

        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            System.out.print(NUMBER_FORMAT_MESSAGE);
            throw new IllegalArgumentException();
        }

        if (money % MIN_COST != 0) {
            System.out.print(COST_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
