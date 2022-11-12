package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    private static final String INSERT_BILL_FOR_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NON_NUMBER_INPUT_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static int getMoneyFromUser() {
        System.out.println(INSERT_BILL_FOR_LOTTO_MESSAGE);
        String input = Console.readLine();
        singleNumberValidate(input);
        return Integer.parseInt(input);
    }

    private static void singleNumberValidate(String input) {
        if(!Pattern.matches(NUMBER_REGEX, input)){
            throw new IllegalArgumentException(NON_NUMBER_INPUT_ERROR);
        }
    }
}
