package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public List<Lotto> buy() throws IllegalArgumentException {
        String money = Console.readLine().trim();
        validateType(money);

        int count = lottoCount(Integer.parseInt(money));
        return getRandomLottoBundle(count);
    }

    private List<Lotto> getRandomLottoBundle(int count) {
        List<Lotto> bundle = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bundle.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return bundle;
    }

    private void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private int lottoCount(int money) throws IllegalArgumentException {
        validateDivisible(money);
        return money / 2;
    }

    private void validateDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
