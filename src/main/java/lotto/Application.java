package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static final String INVALID_AMOUNT_ERROR_MESSAGE = "[ERROR] 올바른 금액을 입력해주세요.";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    public static final String AMOUNT_ENTER_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ANSWER_NUMBER_ENTER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_ENTER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void main(String[] args) {
        Machine machine = new Machine();
        List<Lotto> lottoList = machine.buy(enterAmount());
        getAnswerNumber();
        getBonusNumber();
    }

    private static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_ENTER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> getAnswerNumber() {
        System.out.println(ANSWER_NUMBER_ENTER_MESSAGE);
        return Arrays.stream(Console.readLine().split(","))
                .map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
    }

    private static int enterAmount() {
        System.out.println(AMOUNT_ENTER_MESSAGE);
        String money = Console.readLine();
        isValidAmount(money);
        return Integer.parseInt(money);
    }

    public static void isValidAmount(String enterValue) {
        for (int i = 0; i < enterValue.length(); i++) {
            if (!('0' <= enterValue.charAt(i) && enterValue.charAt(i) <= '9')) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
            }
        }
        if (Integer.parseInt(enterValue) % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERROR_MESSAGE);
        }
    }

}
