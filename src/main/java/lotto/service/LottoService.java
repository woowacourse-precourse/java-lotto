package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> winns, int bonus) {
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        int w5 = 0;
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int cnt = 0;
            int b = 0;
            for (int i = 0; i < 6; i++) {
                if (numbers.get(i) == bonus) b++;
                for (int j = 0; j < 6; j++) {
                    if (numbers.get(i) == winns.get(j)) cnt++;
                }
            }
            if (cnt == 6) w1++;
            else if (cnt == 5 && b == 1) w2++;
            else if (cnt == 5) w3++;
            else if (cnt == 4) w4++;
            else if (cnt == 3) w5++;
        }
        return Arrays.asList(w1, w2, w3, w4, w5);
    }
}
