package game;

import lotto.MakeLotto;
import user.BuyLotto;
import user.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static message.Message.*;

public class PlayGame {
    Scanner sc = new Scanner(System.in);
    MakeLotto makeLotto = new MakeLotto();
    BuyLotto buyLotto = new BuyLotto();
    UserInput userInput = new UserInput();
    Calculate calculate = new Calculate();


    public void run() {
        System.out.println(INPUT_MONEY.getStatus());
        int money = sc.nextInt();

        int lottoCnt = buyLotto.countHowMany(money);
        List<List<Integer>> lottos = makeLotto.publishedLottos(lottoCnt);

        System.out.println(lottoCnt+COUNT_LOTTO.getStatus());

        System.out.println(INPUT_LOTTO_NUMBER.getStatus());
        List<Integer> usersLotto = userInput.userLotto(sc.next());

        System.out.println(INPUT_BONUS_NUMBER.getStatus());
        int bonusNum = userInput.getBonusNumber(sc.nextInt());

        // TODO 수익률을 계산하는 기능 구현
    }

    public void print() {

    }
}
