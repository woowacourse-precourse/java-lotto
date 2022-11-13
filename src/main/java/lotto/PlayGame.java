package lotto;

import user.BuyLotto;

import java.util.Scanner;

import static message.Message.*;

public class PlayGame {
    Scanner sc = new Scanner(System.in);
    BuyLotto buyLotto = new BuyLotto();


    public void run() {
        System.out.println(INPUT_MONEY);
        int money = sc.nextInt();

        int lottoCnt = buyLotto.countHowMany(money);
        System.out.println(lottoCnt +""+ COUNT_LOTTO);

        System.out.println(INPUT_LOTTO_NUMBER);
        String userInput = sc.nextLine();

        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNum = sc.nextInt();

        System.out.println(STATISTICS);
        System.out.println();
    }
}
