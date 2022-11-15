package lotto.domain;

import static lotto.Enum.Values.*;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enum.Notice;
import lotto.Lotto;

import java.util.*;

public class LottoGenerator {

    public List<Lotto> createLottoNumbers(String amount) {
        Notice.BUY_MESSAGE.buy(Integer.parseInt(amount) / LOTTO_AMOUNT.getValue());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(amount) / 1000; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(MAX_VALUE.getValue(), MAX_VALUE.getValue(), COUNT.getValue());
        List<Integer> realLotto = new ArrayList<>();
        for(Integer num : lotto) {
            realLotto.add(num);
        }
        Collections.sort(realLotto);
        return new Lotto(realLotto);
    }

    public Lotto changeToNumber(String numbers) {
        String[] num = numbers.split(",");
        List<Integer> revertNumbers = new ArrayList<>();
        for(String n : num) {
            revertNumbers.add(Integer.parseInt(n));
        }
        return new Lotto(revertNumbers);
    }
}
