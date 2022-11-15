package lotto.domain;

import lotto.utils.InputView;
import lotto.utils.OutputView;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private Lotto lotto;
    private int bonusNumber;

    public WinningNumber() {
        inputWinningNumber();
        inputBonusNumber();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void inputWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();

        OutputView.printWinningNumberMessage();
        String input = InputView.getInputValue();
        String[] inputList = input.split(",");

        Validator.validateForIllegalInput(inputList);

        for (int i = 0; i < inputList.length; i++) {
            int num = Integer.parseInt(inputList[i]);
            winningNumber.add(num);
        }
        Validator.validateForRange(winningNumber);
        lotto = new Lotto(winningNumber);
        OutputView.printLineBreak();
    }

    private void inputBonusNumber() {
        OutputView.printBonusNumberMessage();
        String input = InputView.getInputValue();
        Validator.validateForIllegalInput(input);

        int bonus = Integer.parseInt(input);
        Validator.validateForDuplicatedNumber(lotto, bonus);

        bonusNumber = bonus;
        OutputView.printLineBreak();
    }

}
