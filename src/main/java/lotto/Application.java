package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        printInputMoneyComment();
        Money money = new Money(toInt(Console.readLine()));
        LottoGroups lottos = new LottoGroups(createLottos(money.getNumberToPublishLottos()));

    }

    private static void printInputMoneyComment() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static List<Lotto> createLottos(int numberToPublishLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberToPublishLottos; i++) {
            lottos.add(new Lotto(createRandomNumbers()));
        }
        return lottos;
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

}
