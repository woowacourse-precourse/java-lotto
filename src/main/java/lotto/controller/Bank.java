package lotto.controller;

import java.util.List;
import lotto.model.BankTeller;
import lotto.model.Constants;
import lotto.model.Customer;
import lotto.model.LottoCompany;
import lotto.model.LottoRank;
import lotto.view.StaticOutput;

/**
 * 은행에서는 당첨금을 수령
 */
public class Bank {
    private BankTeller bankTeller;

    public Bank(BankTeller bankTeller) {
        this.bankTeller = bankTeller;
    }

    public void givePrize(Customer customer, LottoCompany lottoCompany) {
        List<LottoRank> lottoRanks = bankTeller.checkLottos(customer, lottoCompany);
        int prize = bankTeller.calculatePrize(lottoRanks);
        int fee = customer.getLottos().size() * Constants.LOTTO_PRICE;
        double roi = bankTeller.calculateROI(prize, fee);
        StaticOutput.printStatistics(lottoRanks, roi);
    }
}
