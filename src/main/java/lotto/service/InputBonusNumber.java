package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputBonusLottoNumberHandler;
import lotto.handler.InputMoneyHandler;
import lotto.view.Output;

import java.util.List;

public class InputBonusNumber {
    InputBonusLottoNumberHandler inputBonusLottoNumberHandler = new InputBonusLottoNumberHandler();
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    Output output = new Output();

    public Integer inputBonusNumber(List<Integer> sixLottoNumbers) {
        output.bonusLottoNumberOrder();
        String inputBonusNumber = userReadLine();
        inputMoneyHandler.checkIsNumber(inputBonusNumber);
        bonusLottoNumber(inputBonusNumber, sixLottoNumbers);
        return Integer.parseInt(inputBonusNumber);
    }

    public String userReadLine() {
        String userLottoNumbers = Console.readLine();

        return userLottoNumbers;
    }
    public void bonusLottoNumber(String bonusNumber, List<Integer> sixLottoNumbers){
        inputBonusLottoNumberHandler.checkBonusNumberException(bonusNumber);
        inputBonusLottoNumberHandler.checkAllNumbersException(bonusNumber, sixLottoNumbers);
    }
}
