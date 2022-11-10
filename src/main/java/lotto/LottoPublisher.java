package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoPublisher {

    public List<Lotto> publishLottos(int payment) {
        // 구입 금액에 따른 로또 개수 계산
        // 개수 만큼 로또 발행
        return null;
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
