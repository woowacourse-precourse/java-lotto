package lotto.Service;

import lotto.Model.ValidNumbers;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

    private static final int MIN_COST = ValidNumbers.valueOf("MIN_COST").getValue();

    private static final String ERROR_HEADER = "[ERROR]";
    private static final String NUMBER_FORMAT_MESSAGE = ERROR_HEADER + " 숫자만 입력 가능합니다.";
    private static final String COST_EXCEPTION_MESSAGE = ERROR_HEADER + " 금액을 1,000원 단위로 입력해주십시오.";
    private static final String LOTTO_FORMAT_MESSAGE = ERROR_HEADER + " 숫자를 쉼표(,)로 구분하여 입력해주십시오.";

    public void validateMoney(String input) {
        int money = returnValidatedSingleNumber(input);

        if (money % MIN_COST != 0) {
            System.out.print(COST_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbers(String input) {
        try {
            Stream.of(input.split("\\s*,\\s*"))
                    .map(n -> (Integer.parseInt(n)))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.print(LOTTO_FORMAT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int returnValidatedSingleNumber(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            System.out.print(NUMBER_FORMAT_MESSAGE);
            throw new IllegalArgumentException();
        }

        return num;
    }
}
