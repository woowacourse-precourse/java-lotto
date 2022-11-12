package lotto.handler;

import lotto.service.InputMoney;
import lotto.service.PickRandomLotto;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumbersHandler {
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    PickRandomLotto pickRandomLotto = new PickRandomLotto();
    InputMoney inputMoney = new InputMoney();
    public List<Integer> checkException(List<Integer> lottoNumbers) {
        checkIsNumber(lottoNumbers);
        checkSize(lottoNumbers);
        checkSameNumbers(lottoNumbers);
        checkInRange(lottoNumbers);
        inputMoney.lineSkip();
        return lottoNumbers;
    }
    private void checkSize(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != pickRandomLotto.LIMIT_LOTTO) {
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }
    private void checkSameNumbers(List<Integer> lottoNumbers){
        if(lottoNumbers.stream().distinct().count() != pickRandomLotto.LIMIT_LOTTO){
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }
    private void checkIsNumber(List<Integer> lottoNumbers){
        for(int index = 0; index < lottoNumbers.size(); index++){
            boolean checkNumeric = String.valueOf(lottoNumbers.get(index)).matches("[+-]?\\d*(\\.\\d+)?");

            if(!checkNumeric){
                throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
            }
        }
    }
    private void checkInRange(List<Integer> lottoNumbers){
        for(int index = 0; index < lottoNumbers.size(); index++){
            if(lottoNumbers.get(index) < 1 || lottoNumbers.get(index) > 45){
                throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
            }
        }
    }
}