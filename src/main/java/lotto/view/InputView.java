package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final String INSERT_BILL_FOR_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INSERT_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NON_NUMBER_INPUT_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static int getMoneyFromUser() {
        System.out.println(INSERT_BILL_FOR_LOTTO_MESSAGE);
        String input = Console.readLine();
        singleNumberValidate(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getManualLottoNumberFromUser() {
        System.out.println(INSERT_LOTTO_NUMBERS_MESSAGE);
        String input = Console.readLine();
        List<String> lottoNumberData = splitInputByComma(input);
        OutputView.printEmptyLine();
        return makeNumbersByString(lottoNumberData);
    }

    public static int getBonusNumberFromUser() {
        System.out.println(INSERT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        singleNumberValidate(input);
        OutputView.printEmptyLine();
        return Integer.parseInt(input);
    }

    private static void singleNumberValidate(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(NON_NUMBER_INPUT_ERROR);
        }
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }

    private static List<Integer> makeNumbersByString(List<String> numberData) {
        List<Integer> result = new ArrayList<>();
        for (String data : numberData) {
            singleNumberValidate(data);
            result.add(Integer.parseInt(data));
        }
        return result;
    }

}
