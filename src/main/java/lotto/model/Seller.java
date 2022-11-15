package lotto.model;

import static lotto.enums.Constant.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Seller {
    public Integer countIssueingLotto(int PurchaseAmount) {
        return PurchaseAmount / PRICE_OF_LOTTO.getValue();
    }

    public List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int issueCount = 1; issueCount <= lottoCount; issueCount++) {
            List<Integer> sorted6Numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(), CORRECT_LOTTO_SIZE.getValue())
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottoNumbers.add(new Lotto(sorted6Numbers));
        }

        return lottoNumbers;
    }
}
