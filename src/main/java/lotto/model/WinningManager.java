package lotto.model;

import static lotto.constant.BonusBallConstants.DUPLICATED_BONUSBALL_INPUt_MSG;
import static lotto.constant.WinningManagerConstants.*;

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

    public List<Integer> resultBy(Lottos lottos) {
        return toRankList(lottos);
    }

    private void validate(BonusBall bonusBall) {
        if (winningLotto.getLotto().contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATED_BONUSBALL_INPUt_MSG);
        }
    }

    private List<Integer> toRankList(Lottos lottos) {
        return lottos.provideLottos().stream()
                .mapToInt(userLotto -> toRank(userLotto))
                .boxed()
                .filter(rank -> rank <= VALID_LOTTO_RANK)
                .collect(Collectors.toList());
    }

    private int toRank(Lotto lotto) {
        int matchedNumberCount = lotto.countContainedNumbersIn(winningLotto.getLotto());

        if (matchedNumberCount == MATCHED_ALL) {
            return FIRST_RANK;
        }
        matchedNumberCount = checkBonusBall(lotto, matchedNumberCount);
        return TO_RANK - matchedNumberCount;
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



