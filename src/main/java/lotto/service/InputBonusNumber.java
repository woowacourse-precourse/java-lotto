package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputBonusLottoNumberHandler;
import lotto.view.Output;

import java.util.List;

public class InputBonusNumber {
    InputBonusLottoNumberHandler inputBonusLottoNumberHandler = new InputBonusLottoNumberHandler();
    Output output = new Output();
    public Integer inputBonusNumber(List<Integer> sixLottoNumbers) {
        output.bonusLottoNumberOrder();

        Integer bonusNumber = Integer.valueOf(userReadLine());
        bonusLottoNumber(String.valueOf(bonusNumber), sixLottoNumbers);
        return bonusNumber;
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
