package lotto.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final String MESSAGE_MONEY = "로또 구입 금액을 입력해 주세요.";
    private static final String MESSAGE_LOTTO_NUMBER = "로또 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String ERROR_INVALID_DELIMITER = "[ERROR] 구분자는 ,로 입력해주세요.";
    private static final String ERROR_INVALID_NUMBER_FORMAT = "[ERROR] 문자가 아닌 숫자만 입력해주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public static int scanMoney() {
        int number;

        System.out.println(MESSAGE_MONEY);
        Scanner scanner = new Scanner(System.in);
        number = parseInt(scanner.nextLine());

        return number;
    }
}
