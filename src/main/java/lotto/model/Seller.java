package lotto.model;

import static lotto.enums.Constant.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Seller {
    public Integer countIssueingLotto(int PurchaseAmount) {
        return PurchaseAmount / PRICE_OF_LOTTO.getValue();
    }

    public List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int issueCount = 1; issueCount <= lottoCount; issueCount++) {
            lottoNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(), CORRECT_LOTTO_SIZE.getValue())));
        }

        return lottoNumbers;
    }
}
