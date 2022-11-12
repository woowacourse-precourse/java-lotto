package lotto;

import java.util.Set;

public class Output {

    public void printMoney(int money) {
        System.out.println(money);
    }

    public void pringLottos(int count, Set<Lotto> lottos) {
        System.out.println(count+"개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

}
