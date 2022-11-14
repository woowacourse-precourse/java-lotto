package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.TotalPrizeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Input {

    private static final String PURCHASEMONEY_REQUEST = "구입금액을 입력해 주세요.";
    private static final String INPUT_IS_NOT_NUMBER = "문자열이 아닌 숫자(정수)를 입력해주세요.";
    private static final String PRIZENUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUSNUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public static int insertPurchaseMoney() {
        System.out.println(PURCHASEMONEY_REQUEST);

        String purchaseMoney = Console.readLine();
        checkNumber(purchaseMoney);
        return parseInt(purchaseMoney);
    }

    public static List<Integer> insertPrizeNumbers() {
        System.out.println(PRIZENUMBER_REQUEST);

        String input = Console.readLine();
        List<String> splitedInput = new ArrayList<String>(Arrays.asList(input.trim().split(",")));

        for (int i = 0; i < splitedInput.size(); i++) {
            checkNumber(splitedInput.get(i));
        }
        List<Integer> prizeNumbers = parsePrizeNumbers(splitedInput);
        TotalPrizeNumbers.validatePrizeNumbers(prizeNumbers);

        return prizeNumbers;
    }

    public static Integer insertBonusNumber() {
        System.out.println(BONUSNUMBER_REQUEST);

        String bonusNumber = Console.readLine();
        checkNumber(bonusNumber);
        return parseInt(bonusNumber);
    }

    private static void checkNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private static List<Integer> parsePrizeNumbers(List<String> splitedInput) {
        return splitedInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
