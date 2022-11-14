package lotto.domain;

public enum LottoReward {

    FIFTH("3개 일치 (5,000원) - %d개", 5_000),
    FIRTH("4개 일치 (50,000원) - %d개", 50_000),
    THIRD("5개 일치 (1,500,000원) - %d개", 15_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원) - %d개", 2_000_000_000);

    private final String rewardLine;
    private final Integer lotteryPrize;

    LottoReward(String rewardLine, Integer lotteryPrize) {
        this.rewardLine = rewardLine;
        this.lotteryPrize = lotteryPrize;
    }

    public static LottoReward from(long count, boolean hasSameBonusNumber) {
        if (count == 3) {
            return LottoReward.FIFTH;
        }
        if (count == 4) {
            return LottoReward.FIRTH;
        }
        if (count == 5 && !hasSameBonusNumber) {
            return LottoReward.THIRD;
        }
        if (count == 5) {
            return LottoReward.SECOND;
        }
        if (count == 6) {
            return LottoReward.FIRST;
        }
        return null;
    }

    public void getReward(long totalRewardCount) {
        System.out.printf(this.rewardLine, totalRewardCount);
        System.out.println();
    }

    public Integer getLotteryPrize() {
        return this.lotteryPrize;
    }
}
