package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private LottoGame() {
    }

    public static LottoGame init() {
        return new LottoGame();
    }

    public void start() {
        Integer moneyEntered = Input.inputMoney();
        validateInputMoney(moneyEntered);
    }

    protected void validateInputMoney(Integer moneyEntered) {
        if(moneyEntered % 1000 != 0) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 숫자를 입력하세요");
        }
        if (moneyEntered < 1000) {
            throw new IllegalArgumentException("1000 이상의 숫자를 입력하세요");
        }
    }
}
