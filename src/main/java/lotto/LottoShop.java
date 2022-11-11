package lotto;

import lotto.exception.PayMoneyException;

import java.util.Collections;
import java.util.List;

public class LottoShop {

    private final MemberWriteService memberWriteService = new MemberWriteService();

    public List<Lotto> createLottoForPayment(String pay) {
        int payMoney = memberWriteService.writePay(pay);
        try {
            int quantity = Lotto.moneyOfQuantity(payMoney);

            return Lotto.createLottoNumbers(quantity);
        } catch (PayMoneyException e) {

            return Collections.emptyList();
        }
    }

    public WinningLottoNumber createWinningLottoNumberFor(String writeLottoNumber, String writeBonusNumber) {
        return memberWriteService.writeWinningLottoNumbers(writeLottoNumber, writeBonusNumber);
    }

}
