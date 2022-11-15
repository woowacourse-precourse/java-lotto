package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Message.*;

public class Game {
    User user = new User();

    public void buyLotto() {
        System.out.println(INPUT_MONEY.getMessage());
        int money = user.inputMoney();
        List<List<Integer>> winLottos = Lotto.makeLotto(Lotto.count(money));
        System.out.println(Lotto.count(money) + COUNT_LOTTO.getMessage());
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }
        System.out.println(INPUT_LOTTO_NUMBER.getMessage());
        List<Integer> list = user.userLotto(Console.readLine());
        List<Integer> usersLotto = new Lotto(list).getNumbers();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = user.getBonusNumber(Integer.parseInt(Console.readLine()));
    }
}