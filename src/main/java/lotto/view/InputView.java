package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static Integer getAmount(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다. ");
        }
    }

    public static List<Integer> getWinningNumber(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(number -> Integer.valueOf(number))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값이 입력됐습니다. ");
        }
    }

    public static Integer getBonusNumber(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력됐습니다. ");
        }
    }

    public static Integer getAmount() {
        return getAmount(readLine());
    }

    public static List<Integer> getWinningNumber() {
        return getWinningNumber(readLine());
    }

    public static Integer getBonusNumber() {
        return getBonusNumber(readLine());
    }
}
