package lotto;

import lotto.verifier.PurchaseManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PurchaseManager purchaseManager = new PurchaseManager();
        LottoGenerator lottoGenerator = new LottoGenerator();
        Collector collector = new Collector();
        Calculator calculator = new Calculator();

        try {
            int money = purchaseManager.askAmountOfMoney();
            List<Lotto> lottoList = lottoGenerator.createLottos(money);
            List<Integer> results = collector.collectResults(lottoList);

            double profitRate = calculator.getProfitRate(results);
            System.out.printf("총 수익률은 %g%%입니다.", profitRate);
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
