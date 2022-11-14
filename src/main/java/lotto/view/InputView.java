package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToNumber(input);
    }

    public static List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(InputView::convertLottoNumber)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return convertLottoNumber(input);
    }

    private static int convertLottoNumber(String input) {
        int number = convertToNumber(input);
        validateLottoNumber(number);
        return number;
    }

    private static int convertToNumber(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!input.matches("^[0-9]*$") || input.isEmpty()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private static void validateLottoNumber(int input) {
        if (input < 1 || input > 46) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력가능합니다.");
        }
    }
}
