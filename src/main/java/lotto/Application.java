package lotto;

import java.util.Collections;
import java.util.List;
import lotto.controller.LottoController;
import lotto.controller.UserController;
import lotto.util.Calculator;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        calculator.getUserBudget();
        calculator.createLotto();
        calculator.getUserInput();
        calculator.getRecord();
        calculator.printResult();
        calculator.printRate();

    }
}
