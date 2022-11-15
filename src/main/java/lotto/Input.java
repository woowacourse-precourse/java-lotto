package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int getCustomerMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Verifier.validateMoney(input);
        int money = Integer.parseInt(input);

        return money;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splittedInput = input.split(",");
        Verifier.validateWinningNumbers(splittedInput);
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

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Verifier.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }
}
