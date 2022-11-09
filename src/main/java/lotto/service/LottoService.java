package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import lotto.Lotto;
import lotto.common.Error;

public class LottoService {

    public List<Lotto> buy(String in) {
        isValid(in);
        int money = getMoney(in);
        return getLottos(money);
    }

    private int getMoney(String in) {
        return Integer.parseInt(in);
    }

    private List<Lotto> getLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfLotto = money /1000;
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private void isValid(String in) {
        int i = 0;
        try {
            i = Integer.parseInt(in);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.NUMBER.getMsg());
        }
        if (i < 1000) {
            throw new IllegalArgumentException(Error.MINUS.getMsg());
        }
        if (i % 1000 != 0) {
            throw new IllegalArgumentException(Error.THOUSAND.getMsg());
        }
    }
}
