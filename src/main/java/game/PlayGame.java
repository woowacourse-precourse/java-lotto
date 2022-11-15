package game;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.MakeLotto;
import user.BuyLotto;
import user.UserInput;

import java.util.List;

import static message.Message.*;
import static message.Statistics.*;


public class PlayGame {
    MakeLotto makeLotto = new MakeLotto();
    UserInput userInput = new UserInput();
    Calculate calculate = new Calculate();
    Print print = new Print();


    public void buyLotto() {
        int lottoCnt = print.getCount();

        List<List<Integer>> winLottos = makeLotto.makeLotto(lottoCnt);
        print.printLotto(winLottos);

        System.out.println(INPUT_LOTTO_NUMBER.getStatus());

        List<Integer> usersLotto = print.getLottoNumber();

        System.out.println(INPUT_BONUS_NUMBER.getStatus());
        int bonusNum = userInput.getBonusNumber(usersLotto, Integer.parseInt(Console.readLine()));

        List<Integer> grades = calculate.correctLottoCount(winLottos, usersLotto, bonusNum);

        String profitRate = calculate.earningRate(grades, lottoCnt);

        print.printStatistics(grades, profitRate);
    }
}
