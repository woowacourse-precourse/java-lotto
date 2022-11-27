package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.messages.ERR_MSG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoPurchaseService {

    private final Integer purchaseQuantities;

    public LottoPurchaseService(String purchaseAmount) {
        validateAmount(purchaseAmount);
        this.purchaseQuantities = calculatePurchaseQuantity(purchaseAmount);
    }

    public List<Lotto> issueLotteries() {
        List<Lotto> lotteries = new ArrayList<>();
        IntStream.range(0, purchaseQuantities).forEach(x -> lotteries.add(createLotto()));
        return lotteries;
    }

    private void validateAmount(String amount) {
        String format = "^[1-9][0-9]*[0]{3}$";
        if (!amount.matches(format)) {
            throw new IllegalArgumentException(ERR_MSG.INVALID_PURCHASE_AMOUNT.getMsg());
        }
    }

    private Integer calculatePurchaseQuantity(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = lottoNumbersCreator();
        return new Lotto(lottoNumbers);
    }

    private List<Integer> lottoNumbersCreator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
