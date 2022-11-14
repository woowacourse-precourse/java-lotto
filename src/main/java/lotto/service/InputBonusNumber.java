package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputBonusLottoNumberHandler;
import lotto.handler.InputMoneyHandler;
import lotto.view.Output;

import java.util.List;

public class InputBonusNumber {
    InputBonusLottoNumberHandler inputBonusLottoNumberHandler = new InputBonusLottoNumberHandler();
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();

    public static String INPUT_BONUS_NUMBER;

    public Integer inputBonusNumber(List<Integer> sixLottoNumbers) {
        Output output = new Output();
        output.bonusLottoNumberOrder();
        INPUT_BONUS_NUMBER = userReadLine();
        inputMoneyHandler.checkIsNumber(INPUT_BONUS_NUMBER);
        bonusLottoNumber(INPUT_BONUS_NUMBER, sixLottoNumbers);
        System.out.println();
        return Integer.parseInt(INPUT_BONUS_NUMBER);
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
