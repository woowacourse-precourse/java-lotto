package lotto.view;


import static lotto.view.SystemMessage.ERROR_MESSAGE;
import static lotto.view.SystemMessage.IS_MONEY_ERROR_MESSAGE;
import static lotto.view.SystemMessage.IS_ONLY_NUMBER_ERROR_MESSAGE;
import static lotto.view.SystemMessage.LOTTO_ONLY_NUMBER_ERROR_MESSAGE;
import static lotto.view.SystemMessage.PATTERN_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private enum Message {
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

    private enum Validation {
        REGEX(","), PATTERN("^[\\w]+,[\\w]+,[\\w]+,[\\w]+,[\\w]+,[\\w]+$");
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
        try {
            System.out.println(Message.PURCHASE_AMOUNT.getValue());
            int money = inputNum();
            return money;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_MONEY_ERROR_MESSAGE);
        }
    }

    public static int inputBonusNumber() {
        try {
            System.out.println(Message.BONUS_NUMBER.getValue());
            Integer number = inputNum();
            return number;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_ONLY_NUMBER_ERROR_MESSAGE);
        }
    }


    private static List<Integer> splitNumbers(final String numbersText) {
        try {
            return Arrays.stream(numbersText.split(Validation.REGEX.getValue()))
                    .map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_ONLY_NUMBER_ERROR_MESSAGE);
        }
    }

    private static List<Integer> inputLottoNumbers() {
        final String lottoNumber = Console.readLine();
        validateLottoNumberPattern(lottoNumber);
        System.out.println();

        List<Integer> splitLotto = splitNumbers(lottoNumber);

        return splitLotto;
    }

    public static List<Integer> getLottoAnswerNumber() {
        System.out.println(Message.LOTTO_ANSWER_NUMBER.getValue());
        return inputLottoNumbers();
    }


    private static void validateLottoNumberPattern(final String rawLottoNumbers) {
        Pattern PATTERN = Pattern.compile(Validation.PATTERN.getValue());
        if (!PATTERN.matcher(rawLottoNumbers).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + PATTERN_ERROR_MESSAGE);
        }
    }


}
