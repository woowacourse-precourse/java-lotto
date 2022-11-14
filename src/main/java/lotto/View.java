package lotto;

import java.util.Collections;
import java.util.List;

public class View {

    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoCount(int count) {
        System.out.println(String.format("%d개를 구입했습니다.", count));
    }

    public static void winNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void BonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void errorMessage(String message) {
        System.out.println(String.format("[ERROR] %s", message));
    }

    public static void lottoNumber(List<Integer> lotto) {
        Collections.sort(lotto);
        System.out.println(lotto);

    }

    public static void moneyPrizes(int money, int prize, int count){
        System.out.printf("%d개 일치(%d 원)- %d개%n", money, prize,count);
    }


    public static void yield(float yield){
        System.out.printf("수익률은 %.2f%% 입니다.%n",yield*100);
    }

    public static void prizes(List<Integer> moneyList){
        moneyPrizes(3,5000, Collections.frequency(moneyList, 5000));
        moneyPrizes(4,50000, Collections.frequency(moneyList, 50000));
        moneyPrizes(5,1500000, Collections.frequency(moneyList, 1500000));
        moneyPrizes(5,30000000, Collections.frequency(moneyList, 30000000));
        moneyPrizes(6, 2000000000,Collections.frequency(moneyList, 2000000000));
    }
}
