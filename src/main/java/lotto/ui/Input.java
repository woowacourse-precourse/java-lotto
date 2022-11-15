package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String inputAmountMessage = "구입 금액을 입력해 주세요.";
    private static final String inputNumbersMessage = "\n당첨 번호를 입력해 주세요.";
    private static final String inputBonusMessage = "\n보너스 번호를 입력해 주세요.";

    public static int inputAmount() {
        System.out.println(inputAmountMessage);
        int amount = parseStrToInt(Console.readLine());
        return amountValidate(amount);
    }

    public static List<Integer> inputNumbers() {
        System.out.println(inputNumbersMessage);
        return parseStrToList(Console.readLine());
    }

    public static int inputBonus(Lotto lotto) {
        System.out.println(inputBonusMessage);
        return bonusValidate(lotto, parseStrToInt(Console.readLine()));
    }

    private static int parseStrToInt(String input) {
        int result;

        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        return result;
    }

    private static int amountValidate(int amount) {
        if (amount % Lotto.lottoPrice != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return amount;
    }

    private static int bonusValidate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복 될 수 없습니다.");
        if (bonus < Lotto.lottoMinNumber || bonus > Lotto.lottoMaxNumber)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");
        return bonus;
    }

    private static List<Integer> parseStrToList(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(parseStrToInt(number));
        }

        return result;
    }
}
