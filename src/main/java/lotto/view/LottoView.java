package lotto.view;

import lotto.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {
    private final Validator validator;

    public LottoView(Validator validator) {
        this.validator = validator;
    }

    public String printMessage(String message) {
        return message;
    }

    public int inputMoney() {
        // 입력값이 정수형태가 아닌경우 NumberFormatException
        int money = Integer.parseInt(readLine());
        validator.validateMoney(money);
        return money;
    }
}
