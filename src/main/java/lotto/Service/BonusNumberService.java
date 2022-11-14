package lotto.Service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Application.ERROR_MESSAGE;
import static lotto.Application.errorContent;

public class BonusNumberService {

    public Integer generateBonusNumber() {
        try {
            Integer bonusNumber = Integer.parseInt(Console.readLine());
            return bonusNumber;
        } catch (NumberFormatException numberFormatException) {
            errorContent = ERROR_MESSAGE + " 보너스 숫자는 숫자만 입력하여야합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }

    public void checkBonusRange(Integer bonusNumber) {
        try {
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            errorContent = ERROR_MESSAGE + " 보너스번호는 1부터 45 사이의 숫자여야 합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }

    public void checkNotEqualWinningNumber(List<Integer> winningNumberList,
                                           Integer bonusNumber) {
        try {
            if (winningNumberList.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            errorContent = ERROR_MESSAGE + " 보너스 번호는 당첨번호와 달라야합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }
}
