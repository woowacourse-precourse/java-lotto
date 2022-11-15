package lotto.domain;

import lotto.dto.WinningLottoNumberDto;
import lotto.exception.PayMoneyException;
import lotto.service.LottoShopService;

import java.util.Collections;
import java.util.List;

public class LottoShop {

    private final LottoShopService lottoShopService = new LottoShopService();

    public List<Lotto> createLottoForMoney(Money money) {
        try {
            int quantity = Lotto.moneyOfQuantity(money.getPayment());

            return Lotto.createLottoNumbers(quantity);
        } catch (PayMoneyException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    public WinningLottoNumberDto createWinningLottoNumberFor(String writeLottoNumber, String writeBonusNumber) {
        return lottoShopService.getWinningLottoNumber(writeLottoNumber, writeBonusNumber);
    }

}
