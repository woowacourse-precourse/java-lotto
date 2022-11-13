package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Purchase purchase;
    List<Integer> lottoAnswer = new ArrayList<>();
    String bonusNumber;

    public void buyLotto() throws IllegalArgumentException {
        Message.startMessage();
        purchase = new Purchase(Console.readLine());

        Message.inputNumberMessage();
        String inputAnswer = Console.readLine();
        Lotto.validateInput(lottoAnswer, inputAnswer);

        Lotto lotto = new Lotto(lottoAnswer);
        Message.inputBonusNumberMessage();

        bonusNumber = Console.readLine();
        lotto.getLottoBonusNumber(bonusNumber);
    }

    public void publishLotto() throws IllegalArgumentException {
        User user = new User();
        user.getUserLotto(purchase.price);
        user.printUserLotto(purchase.price);
        user.printWinningResult(lottoAnswer, bonusNumber);
        user.printWinningRatio(user.achieveMoney, purchase.price);
    }
}
