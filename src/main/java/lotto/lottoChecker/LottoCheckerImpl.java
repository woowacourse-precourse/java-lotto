package lotto.lottoChecker;

import lotto.constants.ExceptionMessage;
import lotto.constants.LottoConstants;
import lotto.numbers.Lotto;
import lotto.numbers.WinningNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCheckerImpl implements LottoChecker{
    private final Set<Integer> winningMainNumbers;
    private final int winningBonusNumber;
    //각 등수를 몇 개씩 맞췄는지 나타내는 int 배열
    //index 0을 제외하고 1부터 1등을 의미한다
    private int[] rankResult;
    //총 상금을 의미한다.
    private int rewardResult = 0;
    private int numberOfBoughtLottos = 0;

    public LottoCheckerImpl(WinningNumbers winningNumbers) {
        this.winningMainNumbers = new HashSet<>(winningNumbers.getNumbers());
        this.winningBonusNumber = winningNumbers.getBonusNumber();
        rankResult = new int[LottoConstants.LAST_RANK + 1];
    }

    @Override
    public void checkLottos(List<Lotto> lottos) {
        this.numberOfBoughtLottos = lottos.size();
        for(Lotto lotto : lottos) {
            int[] matchResult = checkHowManyMatches(lotto.getNumbers());
            WaysToWinAndRewards rank = WaysToWinAndRewards.findByMatches(matchResult);
            if(rank.getRank() >= 1) {
                this.rankResult[rank.getRank()]++;
                this.rewardResult += rank.getReward();
            }
        }
    }

    @Override
    public double calculateROI() {
        int totalInput = LottoConstants.PRICE_OF_LOTTO * this.numberOfBoughtLottos;
        int totalOutput = this.rewardResult;
        return (double)totalOutput / (double)totalInput;
    }
    //return int 배열의 0번째는 메인넘버에서 맞춘 개수, 1번째는 보너스 넘버 맞춤 여부
    @Override
    public int[] checkHowManyMatches(List<Integer> lottoNumbers) {
        if(lottoNumbers == null) throw new IllegalArgumentException(ExceptionMessage.NULL_POINTER);
        int numberOfMainNumberMatches = 0;
        int isBonusNumberMatch = 0;

        for(Integer num : lottoNumbers) {
            if(winningMainNumbers.contains(num)) numberOfMainNumberMatches++;
            if(num.intValue() == winningBonusNumber) isBonusNumberMatch++;
        }
        return new int[] {numberOfMainNumberMatches, isBonusNumberMatch};
    }

    @Override
    public int[] getRankResult() {
        return rankResult;
    }

    @Override
    public int getRewardResult() {
        return rewardResult;
    }
}
