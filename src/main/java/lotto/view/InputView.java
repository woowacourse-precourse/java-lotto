package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";

    public static int readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine().trim();
        System.out.println();

        return convertStringToInteger(input);
    }

    public static int readAmountOfMoney() {
        System.out.println(INPUT_MONEY);
        String input = Console.readLine();
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
}
