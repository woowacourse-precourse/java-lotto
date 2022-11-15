package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputBonusNumberHandler;
import lotto.handler.InputMoneyHandler;
import lotto.view.Output;

import java.util.List;

public class InputBonusNumber {
    public static String inputBonusNumber;
    InputBonusNumberHandler inputBonusNumberHandler = new InputBonusNumberHandler();
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();

    public Integer inputBonusNumber(List<Integer> sixWinningNumbers) {
        Output output = new Output();
        output.bonusLottoNumberOrder();
        inputBonusNumber = Console.readLine();
        inputMoneyHandler.checkIsNumber(inputBonusNumber);
        bonusLottoNumber(inputBonusNumber, sixWinningNumbers);
        output.lineSpace();

        return Integer.parseInt(inputBonusNumber);
    }

    private void bonusLottoNumber(String bonusNumber, List<Integer> sixWinningNumbers){
        inputBonusNumberHandler.checkBonusNumberException(bonusNumber);
        inputBonusNumberHandler.checkAllNumbersException(bonusNumber, sixWinningNumbers);
    }
}