package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.LottoNumberConverter;
import lotto.utils.Validator;

import java.util.List;

public class Input {
    private static final String NUMERIC_ERROR_MSG = "[ERROR] 반드시 숫자여야 합니다.";

    private Input() {}

    public static Integer inputPurchaseLottoValue() {
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            Validator.validateMoney(money);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MSG);
        }
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");
        try {
            String bonusNumber = Console.readLine();
            return LottoNumberConverter.convertWinningNumberToList(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MSG);
        }
    }

    public static Integer inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MSG);
        }
    }
}
