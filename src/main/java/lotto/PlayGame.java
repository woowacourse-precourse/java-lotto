package lotto;

import user.BuyLotto;

import java.util.List;
import java.util.Scanner;

public class PlayGame {
    Scanner sc = new Scanner(System.in);
    BuyLotto buyLotto = new BuyLotto();


    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();

        int lottoCnt = buyLotto.countHowMany(money);
        System.out.println(lottoCnt+"개를 구매했습니다.");

        System.out.println("당첨 번호를 입력해주세요.");
        String userInput = sc.nextLine();

        System.out.println("보너스 번호를 입력해주세요");
        int bonusNum = sc.nextInt();

        System.out.println("당첨통계\n---");
        System.out.println();
    }
}
