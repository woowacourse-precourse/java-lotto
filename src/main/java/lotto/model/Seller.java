package lotto.model;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Seller {
    public Integer countIssueingLotto(int PurchaseAmount) {
        return PurchaseAmount / 1000;
    }

    public List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int issueCount = 1; issueCount <= lottoCount; issueCount++) {
            lottoNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottoNumbers;
    }
}
