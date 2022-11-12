package lotto;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    private static InputView inputView;
    private static User user;
    private static OutputView outputView;
    private static Lotto lotto;
    //private static List<Integer> numbers;


    public static void main(String[] args) {
        // TODO: 프로그램 구현\

        inputView = new InputView();
        outputView = new OutputView();
        user = new User();

        lotto = new Lotto();

        String str = inputView.buyLotto();
        user.checkError(str);
        int count = user.lottoCount(str);
        outputView.lottoCountMsg(count);
        String win = inputView.winningLotto();
        List<Integer> ar = lotto.change(win);
        lotto.checkInput(ar);

        inputView.bonusNumber();


    }

}
