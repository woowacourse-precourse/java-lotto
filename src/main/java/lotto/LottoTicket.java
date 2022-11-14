package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public List<Lotto> buyLotto(String input) {
        List<Lotto> lottos = new ArrayList<>();
        validateInteger(input);
        int money = Integer.parseInt(input);
        canBuyLotto(money);

        for (int ticket = 0; ticket < money / 1000; ticket++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private void validateInteger(String input) {
        if (input.matches("^[0-9]*$")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
    }

    private void canBuyLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상을 입력해 주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력해 주세요.");
        }
    }
}
