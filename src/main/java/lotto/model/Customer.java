package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private final PurchasePrice purchasePrice;
    private List<Lotto> lotteries;

    public Customer(PurchasePrice purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void buy(List<Lotto> lotteries) {
        setLotto(lotteries);
    }

    public MatchResult checkMyLottoNumbers(LottoCompany lottoCompany) {
        return lottoCompany.showResultOfCustomerLotteries(lotteries);
    }

    public double calculateProfit(MatchResult matchResult) {
        return matchResult.getTotalPrizeMoney() / purchasePrice.getPurchasePrice() * 100;
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLotteries() {
        return lotteries.stream().collect(Collectors.toList());
    }

    private void setLotto(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
