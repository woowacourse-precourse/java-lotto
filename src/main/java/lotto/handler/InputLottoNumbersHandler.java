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
        checkSize(lottoNumbers);
        checkSameNumbers(lottoNumbers);
        checkInRange(lottoNumbers);
        inputMoney.lineSkip();
        return lottoNumbers;
    }
    public void checkSize(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != pickRandomLotto.LIMIT_LOTTO) {
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER+" 로또 번호의 개수는 6개여야 합니다.");
        }
    }
    public void checkSameNumbers(List<Integer> lottoNumbers){
        if(lottoNumbers.stream().distinct().count() != pickRandomLotto.LIMIT_LOTTO){
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER+" 로또 번호는 같은 숫자가 중복되지 않아야 합니다.");
        }
    }
    public void checkIsNumber(String[] lottoNumbers){
        for(int index = 0; index < lottoNumbers.length; index++){
            boolean checkNumeric = lottoNumbers[index].matches("[+-]?\\d*(\\.\\d+)?");

            if(!checkNumeric){
                throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER+" 로또 번호는 숫자로 입력되어야 합니다.");
            }
        }
    }
    public void checkInRange(List<Integer> lottoNumbers){
        for(int index = 0; index < lottoNumbers.size(); index++){
            if(lottoNumbers.get(index) < 1 || lottoNumbers.get(index) > 45){
                throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER+" 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}