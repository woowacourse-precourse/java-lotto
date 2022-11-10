package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = Integer.parseInt(Console.readLine());
        moneyInputError(money);
        List<Lotto> lotto = new ArrayList<>();
        buyLotto(money, lotto);
        printLotto(lotto);


    }

    public static void moneyInputError(int money) {
        if (money % 1000 != 0) {
            System.out.println("금액 입력 오류입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void buyLotto(int money, List<Lotto> lotto) {
        int lottoQTY = money / 1000;
        for (int i = 0; i < lottoQTY; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        }
    }

    public static void printLotto(List<Lotto> lotto) {
        for (int i = 0; i < lotto.size(); i++)
            lotto.get(i).printNumbers();
    }

}
