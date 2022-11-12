package lotto;

import java.util.List;

public class Revenue {
    public enum revenueCount {
        THREE("3개 일치 (5,000원) - "), FOUR("4개 일치 (50,000원) - "),FIVE("5개 일치 (1,500,000원) - "),
        FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),SIX("6개 일치 (2,000,000,000원) - ");

        private final String label;

        revenueCount(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    BuyLotto buy = new BuyLotto();

    int threeCount = 0, fourCount = 0, fiveCount = 0, fiveBonusCount = 0, sixCount = 0;
    double revenueRate = 0;
    int price = 0;

    public void revenueCountTmp() {
        BuyLotto buy = new BuyLotto();
        List<List<Integer>> userLottoNumber = buy.lottoNumberMaker();
        this.price = userLottoNumber.size()*1000;
        List<Integer> winLottoNumber = buy.numbers();
        Lotto lotto = new Lotto(winLottoNumber);
        List<Integer> sameNumberCount = lotto.compareList(userLottoNumber, winLottoNumber);
        for (int i = 0; i < sameNumberCount.size(); i++) {
            if (sameNumberCount.get(i) == 3) {
                this.threeCount += 1;
            }
            if (sameNumberCount.get(i) == 4) {
                this.fourCount += 1;
            }
            if (sameNumberCount.get(i) == 5) {
                this.fiveCount += 1;
            }
            if (sameNumberCount.get(i) == 10) {
                this.fiveBonusCount += 1;
            }
            if (sameNumberCount.get(i) == 6) {
                this.sixCount += 1;
            }
        }
    }

    private void revenueRateCalCulator() {
        double sum = 0.0;
        sum += (threeCount*5000 + fourCount*50000 + fiveCount*1500000 + fiveBonusCount*30000000 + sixCount*2000000000);
        double rate = sum / price * 100.0;
        this.revenueRate = ((double)Math.round(rate*10)/10);
    }

    public void revenuePrint() {
        revenueCountTmp();
        revenueRateCalCulator();
        System.out.println();
        System.out.println("당첨 통계\n---");
        System.out.println(revenueCount.THREE.label() + threeCount + "개");
        System.out.println(revenueCount.FOUR.label() + fourCount + "개");
        System.out.println(revenueCount.FIVE.label() + fiveCount + "개");
        System.out.println(revenueCount.FIVE_BONUS.label() + fiveBonusCount + "개");
        System.out.println(revenueCount.SIX.label() + sixCount + "개");
        System.out.println("총 수익률은 "+ revenueRate + "%입니다.");
    }
}
