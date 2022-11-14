package lotto;

import user.BuyLotto;
import user.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static message.ErrorMessage.ABOVE_ELEMENT;
import static message.Message.*;

public class PlayGame {
    Scanner sc = new Scanner(System.in);
    MakeLotto makeLotto = new MakeLotto();
    BuyLotto buyLotto = new BuyLotto();
    Input input = new Input();

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.run();
    }


    public void run() {
        List<Integer> lottoNum = makeLotto.publishedLotto();
        System.out.println(INPUT_MONEY.getStatus());
        int money = sc.nextInt();

        int lottoCnt = buyLotto.countHowMany(money);
        System.out.println(lottoCnt+COUNT_LOTTO.getStatus());

        System.out.println(INPUT_LOTTO_NUMBER.getStatus());
        String str = sc.next();
        List<Integer> userInput = input.userLotto(str);

        System.out.println(INPUT_BONUS_NUMBER.getStatus());
        int bonusNum = sc.nextInt();

        result(userInput, bonusNum, lottoCnt);
    }

    public void result(List<Integer> userInput, int bonusNum, int lottoCnt) {
        if (bonusNum > 45 || bonusNum < 1) throw new IllegalArgumentException(ABOVE_ELEMENT.getStatus());

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(makeLotto.publishedLotto());
        }

        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
