package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amounts;

import java.util.LinkedList;
import java.util.List;

import static lotto.util.ValidUtil.*;

public class Input {

    public static Amounts inputPurchasingAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = validNumber(Console.readLine());
        int amount = validAmountUnit(Integer.parseInt(input));
        return new Amounts(amount);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        String[] numbers = validAllWinningNumber(Console.readLine());

        List<Integer> winningAndBonusNumber = new LinkedList<>();
        for (String number : numbers) {
            winningAndBonusNumber.add(Integer.parseInt(number));
        }

        validateDuplication(winningAndBonusNumber);
        return winningAndBonusNumber;
    }

    public static List<Integer> inputBonusNumber(List<Integer> numbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumberRange(input);

        numbers.add(Integer.parseInt(input));
        validateDuplication(numbers);

        return numbers;
    }

}
