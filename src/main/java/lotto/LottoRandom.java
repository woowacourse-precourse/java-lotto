package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandom {

    public int calculatePurchaseCount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / LottoUtil.LottoNumberPromise.PURCHASE_AMOUNT_UNIT.getValue();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LottoUtil.LottoNumberPromise.PURCHASE_AMOUNT_UNIT.getValue() != 0)
            throw new IllegalArgumentException("구매 금액이 1000원 단위가 아닙니다.");
    }

    public List<List<Integer>> generateRandomLottoNumberList(int purchaseCount) {
        List<List<Integer>> lottoRandomList = new ArrayList<>();
        List<Integer> numbers;

        for (int i = 0; i < purchaseCount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(LottoUtil.LottoNumberPromise.MIN_LOTTO_NUM.getValue(),
                    LottoUtil.LottoNumberPromise.MAX_LOTTO_NUM.getValue(),
                    LottoUtil.LottoNumberPromise.LOTTO_COUNT.getValue());
            if (!LottoUtil.isSorted(numbers)) {
                Collections.sort(numbers);
            }
            lottoRandomList.add(numbers);
        }
        return lottoRandomList;
    }

}
