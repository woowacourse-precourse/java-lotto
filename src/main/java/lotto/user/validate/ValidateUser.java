package lotto.user.validate;

import java.util.regex.Pattern;
import lotto.user.domain.User;

public class ValidateUser {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");
<<<<<<< refs/remotes/origin/chosunghyun18
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private static final int UNIT_MONEY = 1000;

    public static void validateMinAmount(int inputMoney) {
        if (inputMoney < UNIT_MONEY) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 100원 이상입니다");
=======
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateMinAmount(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
>>>>>>> feat(user): add the feature the user input
        }
    }

    public static void validateOnlyNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
