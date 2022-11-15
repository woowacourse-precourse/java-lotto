package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String ERR_INPUT_NOT_INTEGER = "[ERROR] 숫자를 입력 해야 합니다.";
    private static final String INPUT_LOTTO_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

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

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERR_INPUT_NOT_INTEGER);
        }
    }

}
