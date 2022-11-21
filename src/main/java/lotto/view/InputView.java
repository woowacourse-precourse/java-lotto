package lotto.view;

import lotto.domain.Controller;
public class InputView {
    public static void input(Controller controller){
        Comment.inputMoney();
        controller.setUserLotto();
        Comment.inputWinningNumber();
        controller.setWinningLotto();
    }
}
