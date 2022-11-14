package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    private final Integer LOTTO_AMOUNT_EACH = 1000;

    private int countLottos(Integer amount) {
        Integer numOfLotto = amount / LOTTO_AMOUNT_EACH;
        announceNumberOfIssuedLotto(numOfLotto);
        return numOfLotto;
    }

    private void announceNumberOfIssuedLotto(Integer numOfLotto) {
        System.out.printf("%d개를 구매했습니다.\n", numOfLotto);
    }

    public List<Lotto> issueLottos(Integer receivedAmount) {
        Integer numOfLotto = countLottos(receivedAmount);

        List<Lotto> lottos = new ArrayList<>();
        while (numOfLotto > 0) {
            Lotto lotto = autoIssueLotto();
            lottos.add(lotto);

            System.out.println(lotto);

            numOfLotto--;
        }

        return lottos;
    }


    private Lotto autoIssueLotto() {
        List<Integer> autoIssuedNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(autoIssuedNumber);
        Lotto issuedLotto = new Lotto(autoIssuedNumber);
        return issuedLotto;
    }
}
