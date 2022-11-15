package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class InputView {
    public static int inputLottoAmount() {
        OutputView.printInputAmount();
        String money = Console.readLine();
        System.out.println(money);
        try{
            int amount = parseInt(money);
            return amount;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.printWinningNumbers();
        String numberInput = Console.readLine();
        System.out.println(numberInput);
        String[] numbers = numberInput.split(",");
        List<String> numberList = new ArrayList<>(List.of(numbers));
        List<Integer> winningNumbers = numberList.stream()
                .map(number -> parseInt(number))
                .collect(Collectors.toList());
        return winningNumbers;
    }
    public static int inputBonusNumber() {
        OutputView.printBonusNumber();
        String bonusNumber = Console.readLine();
        System.out.println(bonusNumber);
        return parseInt(bonusNumber);
    }
}
