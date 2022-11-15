package game;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.MakeLotto;
import user.BuyLotto;
import user.UserInput;

import java.util.List;

import static message.ErrorMessage.INVALID_NUMBER;
import static message.Message.*;
import static message.Statistics.*;


public class PlayGame {
    BuyLotto buyLotto = new BuyLotto();
    MakeLotto makeLotto = new MakeLotto();
    UserInput userInput = new UserInput();
    Calculate calculate = new Calculate();


    public void buyLotto() {
        System.out.println(INPUT_MONEY.getStatus());
        int money = userInput.inputMoney();
        int lottoCnt = buyLotto.countHowMany(money);

        List<List<Integer>> winLottos = makeLotto.makeLotto(lottoCnt);

        System.out.println(lottoCnt+COUNT_LOTTO.getStatus());
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }

        System.out.println(INPUT_LOTTO_NUMBER.getStatus());

        List<Integer> list = userInput.userLotto(Console.readLine());
        Lotto lotto = new Lotto(list);
        List<Integer> usersLotto = lotto.getNumbers();

        System.out.println(INPUT_BONUS_NUMBER.getStatus());
        int bonusNum = userInput.getBonusNumber(Integer.parseInt(Console.readLine()));

        List<Integer> grades = calculate.correctLottoCount(winLottos, usersLotto, bonusNum);
        String profitRate = calculate.earningRate(grades, money);

        printStatistics(grades, profitRate);


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
