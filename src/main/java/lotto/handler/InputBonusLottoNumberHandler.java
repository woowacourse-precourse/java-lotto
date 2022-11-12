package lotto.handler;

import java.util.List;

public class InputBonusLottoNumberHandler{
    private static final int BONUS_COUNT = 1;
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    public void checkAllNumbersException(String bonusNumber, List<Integer> sixLottoNumbers) {
        if(sixLottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }
    public void checkBonusNumberException(String bonusNumber) {
        inputMoneyHandler.checkIsNumber(bonusNumber);
        checkSize(bonusNumber);
        checkInRange(bonusNumber);
    }

    private void checkInRange(String bonusNumber) {
        if(Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }

    private void checkSize(String bonusNumber) {
        if(bonusNumber.length() != BONUS_COUNT){
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }
}
