package lotto.model;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.utils.LottoNumberGenerator.generateLottoNumber;
import static lotto.validator.MoneyValidator.hasValidPaidMoney;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int paidMoney;
    private final List<Lotto> lottos;

    public Customer(
            int paidMoney
    ) {
        hasValidPaidMoney(paidMoney);
        this.paidMoney = paidMoney;
        this.lottos = generateLottosForCustomer(paidMoney);
    }

    private List<Lotto> generateLottosForCustomer(int paidMoney) {
        List<Lotto> result = new ArrayList<>();
        while (result.size() < (paidMoney / LOTTO_PRICE)) {
            result.add(new Lotto(generateLottoNumber()));
        }
        return result;
    }
}
