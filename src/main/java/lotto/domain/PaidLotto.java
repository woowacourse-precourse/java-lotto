package lotto.domain;

import static lotto.constant.LottoConstant.LEAST_REWARD_NUMBER_COUNT;

public class PaidLotto {

    private final Lotto lotto;
    private boolean isRewarded;
    private LottoReward lottoReward;

    public PaidLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public boolean isRewarded() {
        return this.isRewarded;
    }

    public LottoReward getLottoReward() {
        return this.lottoReward;
    }

    public Integer getLotteryPrize() {
        return this.lottoReward.getLotteryPrize();
    }

    public void compareWith(AnswerLotto answerLotto) {
        long count = this.lotto.countSameLottoNumber(answerLotto);
        toBeWonLotto(count);
        this.lottoReward = LottoReward.from(count,
            this.lotto.contains(answerLotto.getBonusNumber()));
    }

    private void toBeWonLotto(long count) {
        if (isRewarded(count)) {
            this.isRewarded = true;
        }
    }

    private boolean isRewarded(long count) {
        return count >= LEAST_REWARD_NUMBER_COUNT.getValue();
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }

    public boolean hasSameLottoReward(LottoReward lottoReward) {
        return this.lottoReward == lottoReward;
    }
}
