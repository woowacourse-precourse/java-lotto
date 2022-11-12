package lotto;

import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static InputView inputView;
    private static User user;
    private static OutputView outputView;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputView = new InputView();
        outputView = new OutputView();
        user = new User();
        String str = inputView.buyLotto();
        user.checkError(str);
        int count = user.lottoCount(str);
        outputView.lottoCountMsg(count);
    }
}
