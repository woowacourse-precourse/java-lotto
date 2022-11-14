package lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public static void giveMeMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void giveMeWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void giveMeBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoQuantity(int money) {
        System.out.println(Store.countLines(money) + "개를 구매했습니다.");
    }

    public static void lotteriesNumbers(List<Lotto> lotteries) {
        for(Lotto item : lotteries) {
            System.out.println(item.getNumbers());
        }
    }

    public static void winningHistory() {

    }

    public static void earningRate() {

    }

}
