package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

    // 구매할 금액 계산
    public int getPurchaseAmount() {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException(ExceptionCode.INPUT_INVALID.message);
            }
            return purchaseAmount / 1000;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionCode.INPUT_ERROR.message);
        }
    }


    public enum ExceptionCode {
        INPUT_ERROR("[ERROR] 숫자를 입력해주세요."),
        INPUT_INVALID("[ERROR] 천원 단위로 구매할 수 있습니다.");
        private final String message;
        ExceptionCode(String message) {
            this.message = message;
        }
    }
}
