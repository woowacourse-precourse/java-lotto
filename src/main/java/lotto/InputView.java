package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public enum Message {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."), LOTTO_ANSWER_NUMBER("당첨 번호를 입력해 주세요."), BONUS_NUMBER(
                "보너스 번호를 입력해 주세요.");
        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public enum Validation {
        REGEX(",");
        private final String value;

        Validation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    private static int inputNum() {
        String number = Console.readLine();
        System.out.println();
        return Integer.parseInt(number);
    }

    public static int inputMoney() {
        System.out.println(Message.PURCHASE_AMOUNT.getValue());
        return inputNum();
    }

    public static int inputBonusNumber() {
        System.out.println(Message.BONUS_NUMBER.getValue());
        return inputNum();
    }


    private static List<Integer> splitNumbers(final String numbersText) {
        return Arrays.stream(numbersText.split(Validation.REGEX.getValue())).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> inputLottoNums() {
        final String lottoNumber = Console.readLine();
        System.out.println();
        return splitNumbers(lottoNumber);
    }


    public static List<Integer> inputLottoAnswerNumber() {
        System.out.println(Message.LOTTO_ANSWER_NUMBER.getValue());
        return inputLottoNums();
    }

}
