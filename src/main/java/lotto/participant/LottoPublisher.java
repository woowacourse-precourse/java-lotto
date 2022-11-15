package lotto.participant;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoForm;
import lotto.domain.Lotto;

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
        return payment / 1000;
    }

    private Lotto publishLotto() {
        List<Integer> lottoNumbers = publishLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private List<Integer> publishLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoForm.STARTING_NUMBER.getNumber(),
                LottoForm.ENDING_NUMBER.getNumber(),
                LottoForm.COUNT_NUMBER.getNumber());
    }
}
