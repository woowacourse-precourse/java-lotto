package lotto.view;

import static lotto.domain.SystemMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.IS_ONLY_NUMBER_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.LIMIT_NUMBER_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.PATTERN_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        REGEX(","),PATTERN("^[\\w]+,[\\w]+,[\\w]+,[\\w]+,[\\w]+,[\\w]+$");
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

    private static List<Integer> inputLottoNumbers() {
        final String lottoNumber = Console.readLine();
        validateLottoNumberPattern(lottoNumber);
        System.out.println();

        List<Integer> splitLotto = splitNumbers(lottoNumber);

        validateAllLottoNumber(splitLotto);
        return splitLotto;
    }

    public static List<Integer> getLottoAnswerNumber() {
        System.out.println(Message.LOTTO_ANSWER_NUMBER.getValue());
        return inputLottoNumbers();
    }
    private static void validateAllLottoNumber(List<Integer> splitLotto){
        validateLottoNumberDuplicate(splitLotto);
        validateCheckLimit(splitLotto);
        isOnlyNumber(splitLotto);
    }

    private static void validateLottoNumberPattern(final String rawLottoNumbers) {
        Pattern PATTERN = Pattern.compile(Validation.PATTERN.getValue());
        if (!PATTERN.matcher(rawLottoNumbers).matches()) {
            throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
        }
    }

    private static void validateLottoNumberDuplicate(List<Integer> numbers){
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);

        }
    }


    private static void validateCheckLimit(List<Integer> numbers){
        for(Integer num : numbers){
            if(num < 1 || num > 45){
                throw new IllegalArgumentException(LIMIT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private static void isOnlyNumber(List<Integer> numbers){
        for(Integer num : numbers){
            System.out.println(num);
            if(Character.isDigit(num)){
                throw new IllegalArgumentException(IS_ONLY_NUMBER_ERROR_MESSAGE);
            }
        }
    }

}
