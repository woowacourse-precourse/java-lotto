package lotto.view;

import lotto.domain.Controller;

public class OutputView {
    public static void printOutput(Controller controller){
        Comment.startPrintAnswer();
        controller.printResult();
    }
}
