package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final static String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String REQUEST_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private final static String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해주세요.";

    public int inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        return winningNumber;
    }

    public int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

}
