package lotto.handler;

import lotto.view.Output;

import java.util.List;

public class InputBonusNumberHandler {

    public void checkAllNumbersException(String bonusNumber, List<Integer> sixLottoNumbers) {
        Output output = new Output();

        if(sixLottoNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 6개의 로또 번호와 보너스 번호가 중복되지 않아야 합니다.");
        }
    }

    public void checkBonusNumberException(String bonusNumber) {
        checkSize(bonusNumber);
        checkInRange(bonusNumber);
    }

    private void checkInRange(String bonusNumber) {
        Output output = new Output();

        if(Integer.parseInt(bonusNumber) < output.UNDER_LIMIT || Integer.parseInt(bonusNumber) > output.UPPER_LIMIT) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 보너스 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkSize(String bonusNumber) {
        Output output = new Output();

        int bonusUnitsCount = 1;
        int bonusTensCount = 2;

        if(bonusNumber.length() > bonusTensCount || bonusNumber.length() < bonusUnitsCount){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 보너스 로또 번호의 자릿수는 하나 이거나 둘이어야 합니다.");
        }
    }
}