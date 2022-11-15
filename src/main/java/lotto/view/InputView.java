package lotto.view;

import static lotto.constants.ErrorConstant.ERR_INPUT_NOT_INTEGER;
import static lotto.constants.InputConstant.INPUT_BONUS_NUMBER;
import static lotto.constants.InputConstant.INPUT_LOTTO_PURCHASE_MONEY;
import static lotto.constants.InputConstant.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int inputLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY);
        return convertStringToInt(Console.readLine());
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Arrays.stream(Console.readLine().split(","))
                .map(i -> convertStringToInt(i))
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return convertStringToInt(Console.readLine());
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERR_INPUT_NOT_INTEGER);
        }
    }

}
