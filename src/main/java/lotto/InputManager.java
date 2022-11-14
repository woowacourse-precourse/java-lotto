package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputManager {
    public int inputCustomerMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if (!Verifier.isValidMoney(input)) {
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);

        return money;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splittedInput = input.split(",");
        if (!Verifier.isValidWinningNumbers(splittedInput)) {
            throw new IllegalArgumentException();
        }
        List<Integer> winningNumbers = stringArrayToIntegerList(splittedInput);
        return winningNumbers;
    }

    public List<Integer> stringArrayToIntegerList(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(Integer.parseInt(value));
        }
        return result;
    }

    public int inputBonusNumber() {
        return 0;
    }
}
