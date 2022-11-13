package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private int money;

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        money = toInteger(Console.readLine());
        int lottoSheetCount = money / 1000;

        for (int ticket = 0; ticket < lottoSheetCount; ticket++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    public int toInteger(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상을 입력해 주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
        }

        return money;
    }

    public int getLottoSheetCount() {
        return lottos.size();
    }
}
