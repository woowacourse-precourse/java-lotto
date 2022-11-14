package lotto.domain;

import lotto.dto.WinningLottoNumber;
import lotto.exception.PayMoneyException;
import lotto.service.WriteValidation;

import java.util.Collections;
import java.util.List;

public class LottoShop {

    private final WriteValidation validation = new WriteValidation();

    public List<Lotto> createLottoForPayment(Money money) {
        try {
            int quantity = Lotto.moneyOfQuantity(money.getPayment());

            return Lotto.createLottoNumbers(quantity);
        } catch (PayMoneyException e) {

            return Collections.emptyList();
        }
    }

    public WinningLottoNumber createWinningLottoNumberFor(String writeLottoNumber, String writeBonusNumber) {
        return validation.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber);
    }

}
