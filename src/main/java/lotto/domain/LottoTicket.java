package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    private List<Integer> lotto;

    public List<Integer> makeLotto() {
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        printLotto();
        return lotto;
    }

    private void printLotto() {
        System.out.println(lotto);
    }
}
