package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.exception.InputException.inputMoneyException;

public class InputView {
    public static int inputMoney() throws IllegalArgumentException {
        System.out.print("로또 구입 금액을 입력하시오: ");
        return inputMoneyException(Console.readLine());
    }
}
