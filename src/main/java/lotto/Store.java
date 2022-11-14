package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

    public List<Lotto> sell(User user, int receivedMoney) {
        int sellCount = receivedMoney / Constants.LOTTO_PRICE;
        return makeLottos(sellCount);
    }

    private List<Lotto> makeLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Constants.LOTTO_START_NUMBER,
                Constants.LOTTO_END_NUMBER, Constants.LOTTO_LEN));

        numbers.sort(null);
        return numbers;
    }
}
