package lotto.model;

import static lotto.constant.BonusBallConstants.DUPLICATED_BONUSBALL_INPUt_MSG;
import static lotto.constant.RankConstants.VALID_LOTTO_RANK;
import static lotto.constant.WinningManagerConstants.FIRST_RANK_VALUE;
import static lotto.constant.WinningManagerConstants.MATCHED_ALL;
import static lotto.constant.WinningManagerConstants.NEED_TO_CHECK_BONUSBALL;
import static lotto.constant.WinningManagerConstants.TO_RANK_VALUE;

import java.util.List;
import java.util.stream.Collectors;

public class WinningManager {
    private WinningLotto winningLotto;
    private BonusBall bonusBall;

    public static WinningManager from(String userInput) {
        return new WinningManager(userInput);
    }

    private WinningManager(String userInput) {
        this.winningLotto = WinningLotto.from(userInput);
    }

    public void initBonusBall(BonusBall bonusBall) {
        validate(bonusBall);
        this.bonusBall = bonusBall;
    }

    public List<Rank> resultBy(Lottos lottos) {
        return toRanks(lottos);
    }

    private void validate(BonusBall bonusBall) {
        if (winningLotto.getLotto().contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATED_BONUSBALL_INPUt_MSG);
        }
    }

    private List<Rank> toRanks(Lottos lottos) {
        return lottos.provideLottos().stream()
                .mapToInt(userLotto -> toRankValue(userLotto))
                .boxed()
                .filter(rankValue -> rankValue <= VALID_LOTTO_RANK)
                .map(rankValue -> Rank.from(rankValue))
                .collect(Collectors.toList());
    }

    private int toRankValue(Lotto lotto) {
        int matchedNumberCount = lotto.countContainedNumbersIn(winningLotto.getLotto());

        if (matchedNumberCount == MATCHED_ALL) {
            return FIRST_RANK_VALUE;
        }
        matchedNumberCount = checkBonusBall(lotto, matchedNumberCount);
        return TO_RANK_VALUE - matchedNumberCount;
    }

    private int checkBonusBall(Lotto lotto, int matchedNumberCount) {
        if (matchedNumberCount == NEED_TO_CHECK_BONUSBALL) {
            matchedNumberCount = applyBonusBall(lotto, matchedNumberCount);
        }
        return matchedNumberCount;
    }

    private int applyBonusBall(Lotto lotto, int matchedNumberCount) {
        if (lotto.contains(bonusBall)) {
            matchedNumberCount++;
        }
        return matchedNumberCount;
    }
}



