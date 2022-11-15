package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssuedLottos {
    private final List<Lotto> issuedLotto = new ArrayList<>();  // 발행한 로또를 담는 리스트
    private final int issueCount;
    public IssuedLottos(int count) {
        issueCount = count;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            issuedLotto.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getIssuedLotto() {
        return issuedLotto;
    }

    public int getIssueCount() {
        return issueCount;
    }
}
