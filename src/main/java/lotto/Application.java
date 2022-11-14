package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        println("구입금액을 입력해 주세요.");
        Money money = InputHandler.readMoney();
        println();

        List<Lotto> purchasedLottos = LottoShop.purchase(money);
        printPurchasedLottos(purchasedLottos);
        println();
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        println(purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(lotto -> {
            ArrayList<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Integer::compareTo);
            println(numbers);
        });
    }


    private static void println() {
        System.out.println();
    }

    private static void println(Object x) {
        System.out.println(x);
    }
}
