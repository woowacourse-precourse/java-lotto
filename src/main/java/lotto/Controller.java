package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Purchase;
import lotto.Model.User;
import lotto.Model.WinningLotto;
import lotto.domain.LottoGenerator;

public class Controller {
    private View view;
    private Purchase purchase;
    private User user;
    private LottoGenerator lottoGenerator;
    private WinningLotto winningLotto;

    public Controller() {
        view = new View();
        purchase = new Purchase();
        user = new User();
        lottoGenerator = new LottoGenerator();
        winningLotto = new WinningLotto();
    }

    public void buyLotto() throws IllegalArgumentException {
        System.out.println(Constant.ASK_PRICE);
        String money = Console.readLine();
        purchase.setPrice(money);

        user.setPrice(purchase.getPrice());
        user.setUserLotto(lottoGenerator.generateLottoBundle(user.getPrice()));
        user.showUserLottoBundle();
    }

    public void inputNumber(){
        System.out.println(Constant.ASK_WINNING_NUMBER);
        winningLotto.askWinningNumber();
        winningLotto.askBonusNumber();
    }
}
