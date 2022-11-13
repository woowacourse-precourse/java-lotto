package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String PURCHASE_MONEY ="구입금액을 입력해 주세요.";
    private static final String CORRECT_LOTTO_NUMBER ="당첨 번호를 입력해 주세요.";
    private static final String ERROR_1000_NUMBER = "[ERROR] 1,000원 단위로 입력해야합니다.";
    private static final String ERROR_CORRECT_NUMBER = "[ERROR] 올바른 숫자를 입력해야 합니다.";
    private static final String CORRECT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputPurchase() {
        System.out.println(PURCHASE_MONEY);
        int input = isNumber(Console.readLine());
        validate(input);
        return input;
    }

    public void validate(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_1000_NUMBER);
        }
    }

    public List<Integer> inputLottoNumber() {
        System.out.println(CORRECT_LOTTO_NUMBER);
        List<Integer> number = new ArrayList<>();
        String input = Console.readLine();
        String[] inputNumber = input.split(",");
        for (String s : inputNumber) {
            number.add(isNumber(s));
        }
        return number;
    }

    public int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_CORRECT_NUMBER);
        }
        return 0;
    }

    public int inputBonusNumber() {
        System.out.println(CORRECT_BONUS_NUMBER);
        return isNumber(Console.readLine());
    }
}
