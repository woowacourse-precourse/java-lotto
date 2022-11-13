package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String REST = ",";
    private static final String INPUT_WINNING_LOTTO_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_PURCHASE_MONEY_GUIDE = "구입금액을 입력해 주세요.";

    private final InputViewValidator inputViewValidator;

    public InputView() {
        this.inputViewValidator = new InputViewValidator();
    }

    public long inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_GUIDE);
        String text = Console.readLine();
        inputViewValidator.validateNumber(text);
        long inputValue = Long.parseLong(text);
        inputViewValidator.validateDivideThousand(inputValue);
        return inputValue;
    }

    public List<Integer> inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_GUIDE);
        String text = Console.readLine();
        inputViewValidator.validateContainRest(text);
        inputViewValidator.validateSplitByRestNumber(text);
        return Arrays.stream(text.split(REST))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE);
        String text = Console.readLine();
        inputViewValidator.validateNumber(text);
        return Integer.parseInt(text);
    }
}
