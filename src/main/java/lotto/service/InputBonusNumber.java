package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputBonusLottoNumberHandler;
import lotto.view.Output;

import java.util.List;

public class InputBonusNumber {
    InputBonusLottoNumberHandler inputBonusLottoNumberHandler = new InputBonusLottoNumberHandler();
    Output output = new Output();
    public void inputBonusNumber(List<Integer> sixLottoNumbers) {
        output.bonusLottoNumberOrder();
        bonusLottoNumber(userReadLine(), sixLottoNumbers);
    }
    public String userReadLine() {
        String userLottoNumbers = Console.readLine();

        return userLottoNumbers;
    }
    public void bonusLottoNumber(String bonusNumber, List<Integer> sixLottoNumbers){
        InputBonusLottoNumberHandler.checkBonusNumberException(bonusNumber);
        InputBonusLottoNumberHandler.checkAllNumbersException(bonusNumber, sixLottoNumbers);
    }
}
