package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    public List<Lotto> publishLottos(int payment) {
        int numberOfLottos = numberOfLottos(payment);
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != numberOfLottos) {
            lottos.add(publishLotto());
        }
        return lottos;
    }

    private int numberOfLottos(int payment) {
        return payment % 1000;
    }

    private Lotto publishLotto() {
        List<Integer> lottoNumbers = publishLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private List<Integer> publishLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
