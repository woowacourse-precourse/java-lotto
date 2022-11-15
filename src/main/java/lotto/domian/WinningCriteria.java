package lotto.domian;

public class WinningCriteria {
    public enum WinningCriteriaInfo {
        zero(0, 0, ""),
        one(1, 0, ""),
        two(2, 0, ""),
        three(3,5_000,"3개 일치 (5,000원) - "),
        four(4, 50_000, "4개 일치 (50,000원) - "),
        five(5, 1_500_000, "5개 일치 (1,500,000원) - "),
        fiveAndBonus(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        six(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

        private final int label;
        private final int price;
        private final String rankInfo;

        WinningCriteriaInfo(int label, int price, String rankInfo) {
            this.label = label;
            this.price = price;
            this.rankInfo = rankInfo;
        }

        public int getLabel() {
            return label;
        }
        public int getPrice() {
            return price;
        }
        public String getRankInfo() {
            return rankInfo;
        }
        public static WinningCriteriaInfo valueOf(int label) {
            for (WinningCriteriaInfo winning : WinningCriteriaInfo.values()) {
                if (label == winning.label) {
                    return winning;
                }
            }
            return null;
        }
    }
}
