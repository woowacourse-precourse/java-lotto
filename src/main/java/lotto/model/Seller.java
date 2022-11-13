package lotto.model;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Seller {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int CORRECT_NUMBERS_SIZE = 6;

    public Integer countIssueingLotto(int PurchaseAmount) {
        return PurchaseAmount / PRICE_OF_LOTTO;
    }

    public List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int issueCount = 1; issueCount <= lottoCount; issueCount++) {
            lottoNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, CORRECT_NUMBERS_SIZE)));
        }

        return lottoNumbers;
    }
}
