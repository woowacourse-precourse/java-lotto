package lotto;

import lotto.model.User;
import lotto.view.InputView;

public class Application {

    private static InputView inputView;
    private static User user;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputView = new InputView();
        user = new User();
        String str = inputView.buyLotto();
        user.isNumber(str);
    }
}
