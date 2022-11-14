package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    public int inputPaidMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!validateInputOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!validateInputNumberAndComma(input)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean validateInputOnlyNumber(String input) {
        return input.matches("[0-9]*");
    }

    private boolean validateInputNumberAndComma(String input) {
        return input.matches("[,0-9]*");
    }
}
