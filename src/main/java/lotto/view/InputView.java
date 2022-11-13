package lotto.view;

import java.util.regex.Pattern;
import lotto.view.utils.OutputUtils;
import lotto.view.utils.UserInputUtils;

public final class InputView {

    private static final String INPUT_TYPE = "^[0-9]*$";

    private InputView() {
    }

    public static int inputLotteryPurchaseAmount() {
        OutputUtils.outputLine("구입금액을 입력해 주세요");
        String input = UserInputUtils.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        if (!Pattern.matches(INPUT_TYPE, input)) {
            OutputView.printException(new IllegalArgumentException("입력 타입은 숫자이여야 합니다."));
        }
    }
}
