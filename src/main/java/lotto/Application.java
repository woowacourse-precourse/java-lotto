package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int convertMoneyInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch(Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> convertNumbersInput(String input) {
        List<String> splitedInput = List.of(input.split(","));


        try {
            List<Integer> numbers = splitedInput.stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());

            return numbers;
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }

    }

    public static int convertBonusNumberInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        int money;
        List<Integer> winningNumbers;
        int bonusNumber;
        Lotto winningLotto;
        User user;

        money = convertMoneyInput(readLine());
        user = new User(money);
        user.printLottos();

        winningNumbers = convertNumbersInput(readLine());
        winningLotto = new Lotto(winningNumbers);

        bonusNumber = convertBonusNumberInput(readLine());
        Lotto.setBonusNumber(bonusNumber);

    }
}
