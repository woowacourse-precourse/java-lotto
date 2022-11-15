package game;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.MakeLotto;
import user.BuyLotto;
import user.UserInput;

import java.util.ArrayList;
import java.util.List;

import static message.Message.*;


public class PlayGame {
    BuyLotto buyLotto = new BuyLotto();
    MakeLotto makeLotto = new MakeLotto();
    UserInput userInput = new UserInput();
    Calculate calculate = new Calculate();


    public void run() {
        System.out.println(INPUT_MONEY.getStatus());
        int money = Integer.parseInt(Console.readLine());

        int lottoCnt = buyLotto.countHowMany(money);

        List<List<Integer>> winLottos = makeLotto.makeLotto(lottoCnt);

        System.out.println(lottoCnt + COUNT_LOTTO.getStatus());

        System.out.println(INPUT_LOTTO_NUMBER.getStatus());
        List<Integer> usersLotto = userInput.userLotto(Console.readLine());

        System.out.println(INPUT_BONUS_NUMBER.getStatus());
        int bonusNum = userInput.getBonusNumber(Integer.parseInt(Console.readLine()));


        List<Integer> grades = calculate.correctLottoCount(winLottos, usersLotto, bonusNum);
        String profitRate = calculate.earningRate(grades, money);

        print(grades, profitRate);
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }
    }

    public void print(List<Integer> grades, String profitRate) {
        System.out.println("당첨통계\n---");
        System.out.println("3개 일치 (5,000원) - " + grades.get(5) +"개");
        System.out.println("4개 일치 (50,000원) - " + grades.get(4) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + grades.get(3) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + grades.get(2) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + grades.get(1) +"개");
        System.out.println("총 수익률은 " + profitRate+"% 입니다");
    }
}
