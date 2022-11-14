package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoStore {

    private static final Integer LOTTO_AMOUNT_EACH = 1000;

    private int countLottos(Integer amount) {
        Integer numOfLotto = amount / LOTTO_AMOUNT_EACH;
        announceNumberOfIssuedLotto(numOfLotto);
        return numOfLotto;
    }

    private void announceNumberOfIssuedLotto(Integer numOfLotto) {
        System.out.printf("%d개를 구매했습니다.\n", numOfLotto);
    }

}
