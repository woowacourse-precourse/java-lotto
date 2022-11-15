package game;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import user.BuyLotto;
import user.UserInput;

import java.util.List;

import static message.Message.*;
import static message.Statistics.*;

public class Print {
    UserInput userInput = new UserInput();
    BuyLotto buyLotto = new BuyLotto();


    public int getCount() {
        System.out.println(INPUT_MONEY.getStatus());
        int money = userInput.inputMoney();
        int lottoCnt = buyLotto.countHowMany(money);

        System.out.println(lottoCnt+COUNT_LOTTO.getStatus());

        return lottoCnt;
    }

    public void printLotto(List<List<Integer>> winLottos) {
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }
    }

    public List<Integer> getLottoNumber() {
        List<Integer> list = userInput.userLotto(Console.readLine());
        Lotto lotto = new Lotto(list);

        return lotto.getNumbers();
    }

    public void printStatistics(List<Integer> grades, String profitRate) {
        System.out.println(MESSAGES.getMessage());
        System.out.println(FIVE.getMessage() + grades.get(5) + COUNT.getMessage());
        System.out.println(FOUR.getMessage() + grades.get(4) +COUNT.getMessage());
        System.out.println(THREE.getMessage() + grades.get(3) +COUNT.getMessage());
        System.out.println(TWO.getMessage() + grades.get(2) +COUNT.getMessage());
        System.out.println(ONE.getMessage() + grades.get(1) +COUNT.getMessage());
        System.out.println(RATE.getMessage() +profitRate+STR.getMessage());
    }
}
