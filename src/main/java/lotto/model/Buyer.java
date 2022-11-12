package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validator;

public class Buyer {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String MESSAGE_COUNT_BUY = "%d개를 구매했습니다.";


    private int countLottos;
    private List<Lotto> lottos;
    private Validator validator = new Validator();

    public Buyer(int money) {
        validator.validateUnit(money);
        this.countLottos = money / MIN_BUY_UNIT;
        buyLottos();
    }

    private Lotto makeLotto() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        List<Integer> numbers = new ArrayList<>(randoms);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void buyLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLottos; i++) {
            lottos.add(makeLotto());
        }
        this.lottos = lottos;
    }

    public void printBuyLottos() {
        System.out.println(String.format(MESSAGE_COUNT_BUY, countLottos));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void compareAllLottos(LottoStore store) {
        for (Lotto lotto : lottos) {
            store.compareLotto(lotto);
        }
    }
}
