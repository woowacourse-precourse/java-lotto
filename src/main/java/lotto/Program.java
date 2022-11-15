package lotto;

import lotto.domain.Controller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Program {
    Controller controller;

    Program(){controller=new Controller();}

    public void startProgram(){
        InputView.input(controller);
        controller.calculateResult();
        OutputView.printOutput(controller);
    }
}
