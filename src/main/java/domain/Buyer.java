package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {

    private final int purchaseAmount;
    private final static int pricePerLotto = 1000;
    private final List<Lotto> buyerLotto = new ArrayList<>();
    private final Map<Winnings, Integer> winningStatistics = new HashMap<>();

    public Buyer(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        addBuyerLotto(purchaseAmount);
    }

    public String calculateReturnRate() {
        double returnRate = 0.0;
        for (Winnings winnings : winningStatistics.keySet()) {
            returnRate += winnings.getPrice() * winningStatistics.get(winnings);
        }
        returnRate /= purchaseAmount;
        return String.format("%.1f", returnRate*100);
    }

    public Map<Winnings, Integer> putWinningStatistics(WinningNumber winningNumber) {
        for (Winnings winnings : Winnings.values()) {
            winningStatistics.put(winnings, 0);
        }
        for (Lotto lotto : buyerLotto) {
            Winnings winnings = lotto.compare(winningNumber);
            winningStatistics.replace(winnings, winningStatistics.get(winnings) + 1);
        }
        return winningStatistics;
    }

    private void addBuyerLotto(int purchaseAmount) {
        int cntOfLotto = purchaseAmount / pricePerLotto;
        System.out.println(cntOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < cntOfLotto; ++i) {
            List<Integer> lottoNumber = NumberGenerator.createLottoNumber().getNumbers();
            System.out.println(lottoNumber.toString());
            buyerLotto.add(new Lotto(lottoNumber));
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % pricePerLotto != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<Winnings, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public List<Lotto> getBuyerLotto() {
        return buyerLotto;
    }
}
