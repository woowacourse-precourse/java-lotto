package lotto;

import static lotto.Constant.NUMBER_REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        if (!inputValue.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다");
        }
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> digits = List.of(input.split(","));
        if (!digits.stream().allMatch(digit -> digit.matches(NUMBER_REGEX))) {
            throw new IllegalArgumentException("1,2,3,4,5,6 과 같은 형태로 입력해야 합니다");
        }
        return digits.stream().map(digit -> Integer.parseInt(digit)).collect(Collectors.toList());
    }

    public static Integer inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다");
        }
        return Integer.parseInt(input);
    }
}
