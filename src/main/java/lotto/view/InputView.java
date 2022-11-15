package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;
import lotto.validation.InputValidation;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.MessageConstant.*;

public class InputView {

    private final OutputView outputView = new OutputView();
    public UserLotto inputUserMoney() {
        printRequestMoneyInputMessage();
        String inputMoney = Console.readLine();

        InputValidation.isValidInput(inputMoney);
        return new UserLotto(Integer.parseInt(inputMoney));
    }

    private void printRequestMoneyInputMessage() {
        System.out.println(MESSAGE_INPUT_MONEY);
    }

    public List<Integer> inputWinningNumbers() {
        printRequestWinningNumbersMessage();
        String inputWinning = Console.readLine();
        List<Integer> winningNumbers = castToList(inputWinning);

        LottoValidation.isValidLotto(winningNumbers);
        return winningNumbers;
    }

    private void printRequestWinningNumbersMessage() {
        System.out.println(MESSAGE_INPUT_WINNING_NUMBER);
    }

    private List<Integer> castToList(String inputWinning) {
        List<Integer> winningNumbers = new ArrayList<>();

        for(String input : inputWinning.split(",")) {
            InputValidation.isValidInput(input);
            winningNumbers.add(Integer.valueOf(input));
        }

        return winningNumbers;
    }

    public int inputBonusNumber() {
        outputView.printBlankLine();
        printRequestBonusNumberMessage();
        String inputBonus = Console.readLine();

        InputValidation.isValidInput(inputBonus);
        LottoValidation.isValidRangeOfBonusNumber(inputBonus);

        return Integer.parseInt(inputBonus);
    }

    private void printRequestBonusNumberMessage() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
    }
}
