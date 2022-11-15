package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private final PurchasePrice money;
    private List<Lotto> lotteries;

    public Customer(PurchasePrice money) {
        this.money = money;
    }

    public void buy(List<Lotto> lotteries) {
        setLotto(lotteries);
    }

    public PurchasePrice getMoney() {
        return money;
    }

    public List<Lotto> getLotteries() {
        return lotteries.stream().collect(Collectors.toList());
    }

    public MatchResult checkMyLottoNumbers(LottoCompany lottoCompany) {
        return lottoCompany.showResultOfCustomerLotteries(lotteries);
    }

    public double calculateProfit(MatchResult matchResult) {
        return matchResult.getTotalPrizeMoney() / money.getPrice() * 100;
    }

    private void setLotto(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
