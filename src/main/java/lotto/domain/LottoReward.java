package lotto.domain;

import lotto.message.ExceptionMessage;

public enum LottoReward {

    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FORTH(50000, 4, false),
    FIFTH(5000, 3, false);

    public final int REWARD;
    public final int COUNT;
    public final boolean BONUS_NUMBER;

    LottoReward(int REWARD, int COUNT, boolean BONUS_NUMBER) {
        this.REWARD = REWARD;
        this.COUNT = COUNT;
        this.BONUS_NUMBER = BONUS_NUMBER;
    }

    public static LottoReward getAward(int count, boolean bonusNumber){
        for(LottoReward lottoReward: values()){
            if(lottoReward.COUNT == count && lottoReward.BONUS_NUMBER == bonusNumber){
                return lottoReward;
            }
        }
        throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_WINNING_LOTTO);
    }

    @Override
    public String toString() {
        return String.format("%,d원", REWARD);
    }
}
