package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String DELIMITER = ",";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해 주세요.";
    private static final String SEPARATOR_ERROR = "[ERROR] 구분자 '" + DELIMITER + "' 를 입력해 주세요.";

    public static int number() {
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }


}
