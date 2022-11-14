package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String COMMA_DELIMITER = ",";
    private static final String ALL_WHITE_SPACE = "\\s";
    private static final String EMPTY_STRING = "";


    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = readWithoutWhiteSpace();
        System.out.println();

        return convertStringToInteger(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = readWithoutWhiteSpace();
        System.out.println();

        return convertStringToIntegerList(input);
    }

    public static int readAmountOfMoney() {
        System.out.println(INPUT_MONEY);
        String input = readWithoutWhiteSpace();
        System.out.println();

        return convertStringToInteger(input);
    }

    private static Integer convertStringToInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER))
                .map(InputView::convertStringToInteger)
                .collect(Collectors.toList());
    }

    private static String readWithoutWhiteSpace() {
        String input = Console.readLine();
        return input.replaceAll(ALL_WHITE_SPACE, EMPTY_STRING);
    }
}
