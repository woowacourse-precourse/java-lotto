package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoVendingMachine {
    private final int PRICE_OF_LOTTO = 1000;

    public List<Lotto> publishLotto(int moneyInput) {
        checkMoneyInput(moneyInput);
        int numberOfLotto = moneyInput / PRICE_OF_LOTTO;
        ArrayList<Lotto> publishedLotto = new ArrayList<>();

        // 액수만큼 로또 발행
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            publishedLotto.add(new Lotto(numbers));
        }

        return publishedLotto;
    }

    private void checkMoneyInput(int moneyInput) {
        if (moneyInput % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 돈을 넣어주세요");
    }
}
