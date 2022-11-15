package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int getCustomerMoney() {
        String input = Console.readLine();
        Verifier.validateMoney(input);
        int money = Integer.parseInt(input);
        return money;
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] splittedInput = input.split(",");
        Verifier.validateLottoNumbers(splittedInput);
        List<Integer> winningNumbers = stringArrayToIntegerList(splittedInput);
        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        Verifier.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }

    private List<Integer> stringArrayToIntegerList(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(Integer.parseInt(value));
        }
        return result;
    }
}
