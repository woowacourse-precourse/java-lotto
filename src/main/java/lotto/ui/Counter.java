package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private static final String inputAmountMessage = "구입 금액을 입력해 주세요.";
    private static final String inputNumbersMessage = "당첨 번호를 입력해 주세요.";

    public int inputAmount() {
        System.out.println(inputAmountMessage);
        int amount = parseStrToInt(Console.readLine());
        return amountValidate(amount);
    }

    public List<Integer> inputNumbers() {
        System.out.println(inputNumbersMessage);
        return parseStrToList(Console.readLine());
    }

    private int parseStrToInt(String input) {
        int result;

        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
        return result;
    }

    private int amountValidate(int amount) {
        if (amount % Lotto.lottoPrice != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        return amount;
    }

    private List<Integer> numbersValidate(List<Integer> numbers) {
        new Lotto(numbers);
        return numbers;
    }

    private List<Integer> parseStrToList(String input) {
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(parseStrToInt(number));
        }

        return numbersValidate(result);
    }
}
