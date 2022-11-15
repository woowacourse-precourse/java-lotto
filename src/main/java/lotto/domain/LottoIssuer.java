package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class LottoIssuer {

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> generateAllLotto(Amounts amount) {
        int lottoNumber = amount.getMoney() / 1000;
        final List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

}
