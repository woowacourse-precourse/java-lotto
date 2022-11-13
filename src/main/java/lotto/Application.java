package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = toInteger(Console.readLine());
        int lottoSheetCount = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int ticket = 0; ticket < lottoSheetCount; ticket++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        System.out.println(lottos.toString());

    }

    private static int toInteger(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상을 입력해 주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
        }

        return money;
    }
}
